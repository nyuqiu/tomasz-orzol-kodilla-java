package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Map;

public class OrderRequest {

    private User user;
    private Map<String, Integer> orderedProducts;
    private String address;

    public OrderRequest(User user, Map<String, Integer> orderedProducts, String address) {
        this.user = user;
        this.orderedProducts = orderedProducts;
        this.address = address;
    }

    public boolean createOrder(User user, Map<String, Integer> orderedProducts, String address) {
        if(orderedProducts!=null && address!=null) {
            System.out.println("Creating order for "+ user.getName()+" "+user.getSurname()+" with product "+orderedProducts+ ", for address "+address);
            return true;
        } else {
            System.out.println("Product not avaiable/Address not correct");
            return false;
        }
    }

    public Map<String, Integer> getOrderedProducts() {
        return orderedProducts;
    }

    public User getUser() {
        return user;
    }

    public String getAddress() {
        return address;
    }
}
