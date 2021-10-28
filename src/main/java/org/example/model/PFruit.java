package org.example.model;

public class PFruit extends Product{

    public PFruit(int id, int price, String productName, String description) {
        this.id = id;
        this.price = price;
        this.productName = productName;
        this.description = description;
    }

    @Override
    public String examine() {
        String result = "The Fruit id is : " + getId() + "\nThe Fruit name is: " + getProductName() + "\nThe Fruit price is: " + getPrice();
        return result;
    }

    @Override
    public String use() {
        String description = "You drink some " + getProductName() + ". " + getDescription();

        return description;
    }
}
