package org.example.model;



import java.util.List;

public interface VendingMachine {

    boolean addCurrency(int amount);
    int getBalance();
    int request(int id);
    int endSession();
    String TargetDescription(int id);
    String getDescription(Product p);
    List<Product> getProducts();
}
