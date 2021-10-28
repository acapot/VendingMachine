package org.example.model;

public class PSnack extends Product{

    public PSnack(int id, int price, String productName, String description) {
        this.id = id;
        this.price = price;
        this.productName = productName;
        this.description = description;
    }

    @Override
    public String examine() {
        String result = "The Snack id is : " + getId() + "\nThe Snack name is: " + getProductName() + "\nThe Snack price is: " + getPrice();
        return result;
    }

    @Override
    public String use() {
        return "You eat some " + productName;
    }
}
