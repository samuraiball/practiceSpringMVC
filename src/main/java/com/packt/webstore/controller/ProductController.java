package com.packt.webstore.controller;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import com.packt.webstore.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
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

    @RequestMapping("/update/stock")
    public String updateStock(Model model) {
        productService.updateAllStock();
        return "redirect:/products";
    }

    @RequestMapping("/products/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory){
        model.addAttribute("products",productService.getProductsByCategory(productCategory));
        return "products";
    }

    @RequestMapping("/products/filter/{params}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }


    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String addNewProduct(@ModelAttribute("newProduct") Product newProduct, Model model){
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct){
        productService.addProduct(newProduct);
        return "redirect:/market/products";
    }

}
