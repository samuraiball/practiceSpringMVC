package com.packt.webstore.validator;


import com.packt.webstore.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

@Component
public class UnitsInStockValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    public void validate(Object terget, Errors errors) {
        Product product = (Product) terget;
        if (product.getUnitPrice() != null &&
                new BigDecimal(1000).compareTo(product.getUnitPrice()) <= 0
                && product.getUnitsInStock()>99) {
            errors.rejectValue("unitsInStock","com.packt.webstore.validator.UnitsInStockValidator.message");

        }
    }
}
