package org.example.model;

public class PDrink extends Product{

    private boolean alcoholic;
    private int sugarPercentage;
    //private double price;

    public PDrink(int id, int price, String productName, String description, boolean alcoholic) {
        this.id = id;
        this.productName = productName;
        this.alcoholic = alcoholic;
        //this.sugarPercentage = sugarPercentage;
        this.price = price;
        this.description = description;
    }

    @Override
    public String examine() {
        String result = "The Drink id is : " + getId() + "\nThe Drink name is: " + getProductName() + "\nThe Drink price is: " + getPrice();
        return result;
    }

    @Override
    public String use() {
        String description = "You drink some " + getProductName();
        description = description + (alcoholic ? " and feel a bit tipsy" : "");
        return description;
    }
}
