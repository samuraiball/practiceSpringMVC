package com.packt.webstore.domain;

import com.packt.webstore.validator.ProductId;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

    private static final long serialVersionUID = 3678107792576131001L;

    @ProductId
    @Pattern(regexp = "P[1-9]+", message = "{Pattern.Product.productId.validation}")
    private String productId;

    @NotNull
    @Size(min = 4, max = 50, message = "{Size.Product.name.validation}")
    private String name;

    @Min(value = 0, message = "{Min.Product.unitPrice.validation}")
    @Digits(integer = 8,fraction = 2,message = "{Digit.Product.unitPrice.validation}")
    @NotNull(message = "{NotNull.Product.unitPrice.validation}")
    private BigDecimal unitPrice;
    private String description;
    private String manufacturer;
    private String category;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discontinued;
    private String condition;

    public Product() {
        super();
    }

    public Product(String productId, String name, BigDecimal
            unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public void setUnitsInOrder(long unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public long getUnitsInStock() {
        return unitsInStock;
    }

    public long getUnitsInOrder() {
        return unitsInOrder;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((productId == null) ? 0 :
                productId.hashCode());
        return result;
    }

}
