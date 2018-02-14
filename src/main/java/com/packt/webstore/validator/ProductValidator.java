package com.packt.webstore.validator;

import com.packt.webstore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

public class ProductValidator implements Validator {
    @Autowired
    private javax.validation.Validator beanValidator;

    private Set<Validator> sprignValidator;

    public ProductValidator(){
        sprignValidator = new HashSet<Validator>();
    }

    public void setSpringValidator(Set<Validator> sprignValidator){
        this.sprignValidator = sprignValidator;
    }

    public boolean supports(Class<?> clazz){
        return Product.class.isAssignableFrom(clazz);
    }

    public void validate(Object terget, Errors errors){
        Set<ConstraintViolation<Object>> constraintViolations =beanValidator.validate(terget);
        for (ConstraintViolation<Object> constraintViolation : constraintViolations){
            String propertyPath = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            errors.rejectValue(propertyPath," ", message);
        }

        for(Validator validator : sprignValidator){
            validator.validate(terget,errors);
        }
    }
}
