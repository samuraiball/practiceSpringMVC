package com.packt.webstore.validator;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exeption.ProductNotFoundException;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductIdValidator implements ConstraintValidator<ProductId, String> {
    @Autowired
    private ProductService productService;

    public void initialize(ProductId custumAnnotation) {
        /*初期化のためのクラス。どんな繊細なデフォルトのバリューでも初期化できるように*/
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        Product product;
        try {
            product = productService.getProduct(value);
        } catch (ProductNotFoundException e) {
            return true;
        }
        if (product != null) {
            return false;
        }
        return true;
    }
}
