package com.packt.webstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;


public class CategoryValidator implements ConstraintValidator<Category, String> {


    public void initialize(Category coustomAnnotation) {

    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> categories = new ArrayList<>();

        categories.add("Java");
        categories.add("Spring");
        categories.add("test");

        for(String a : categories){
            if(a.equals(value))return true;
        }

        return false;
    }
}
