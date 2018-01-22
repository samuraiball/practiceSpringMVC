package com.packt.webstore.exeption;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "no products found under the category")
public class NoProductsFoundUnderCategoryException extends RuntimeException {

    private static final long serialVersionUID =
            3935230281455340039L;
}
