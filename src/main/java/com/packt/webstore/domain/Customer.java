package com.packt.webstore.domain;

import java.io.Serializable;

public class Customer implements Serializable {

    String CustomerId;
    String name;
    String address;
    String noOfOrdersMade;

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(String noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }
}
