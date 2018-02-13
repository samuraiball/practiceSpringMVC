package com.packt.webstore.controller;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exeption.NoProductsFoundUnderCategoryException;
import com.packt.webstore.exeption.ProductNotFoundException;
import com.packt.webstore.service.ProductService;
import com.packt.webstore.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("market")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductServiceImpl productServiceImp;

    @RequestMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productServiceImp.getAllProducts());
        return "products";
    }

    @RequestMapping("/product")
    public String product(Model model, @ModelAttribute("productId") String productId) {
        model.addAttribute("product", productServiceImp.getProduct(productId));
        return "product";
    }

    @RequestMapping("/update/stock")
    public String updateStock(Model model) {
        productService.updateAllStock();
        return "redirect:/products";
    }

    @RequestMapping("/products/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
        List<Product> products = productService.getProductsByCategory(productCategory);
        if (products == null || products.isEmpty()) {
            throw new NoProductsFoundUnderCategoryException();
        }
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping("/products/filter/{params}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }


    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String addNewProduct(@ModelAttribute("newProduct") Product newProduct, Model model) {
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result) {

        if (result.hasErrors()) {
            return "addProduct";
        }
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " +
                    StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        productService.addProduct(newProduct);
        return "redirect:/market/products";
    }

    @RequestMapping("/products/invalidPromoCode")
    public String invalidPromoCode() {
        return "invalidPromoCode";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setAllowedFields("productId",
                "name",
                "unitPrice",
                "description",
                "manufacturer",
                "category",
                "unitsInStock",
                "condition",
                "unitsInOrder",
                "discontinued");
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest request,
                                    ProductNotFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidProductId", exception.getProductId());
        mav.addObject("exception", exception);
        mav.addObject("url", request.getRequestURL() + "?" + request.getQueryString());
        mav.setViewName("productNotFound");
        return mav;
    }
}
