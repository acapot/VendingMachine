package org.example.model;

import java.util.List;

import java.util.Scanner;

public class VendingMachineImpl implements VendingMachine {

    private List<Product> products;
    int depositPool;
    //int totalToPay;
    private Scanner SCANNER = new Scanner(System.in);

    public VendingMachineImpl(List<Product> products) {
        this.products = products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getDepositPool() {
        return depositPool;
    }

    /*public int calculateTotalToPay(Product[] products){
        for(Product p : products){
            totalToPay += p.getPrice();
        }
        return totalToPay
    }*/

    public void setDepositPool(int depositPool) {
        this.depositPool += depositPool;
    }

    public void run(){
        showProducts();

        String str = "";
        int chosenProductId =0;

        while(str == ""){
            chosenProductId=getChosenProduct();
            str = TargetDescription(chosenProductId);
        }

        boolean validValue = addCurrency(getCurrency());
        while(!validValue){
            validValue = addCurrency(getCurrency());
        }

        int priceChosenProd = request(chosenProductId);
        getChange(priceChosenProd);
        endSession();



        //getCurrency();
        //int idChosen = SCANNER.nextInt();
    }

    public void getChange(int priceChP){
        int change = getBalance() - priceChP;
        System.out.println("Your change is: " + change);
    }

    public int getCurrency(){
        System.out.println("Add money to the deposit pool. Only accepts the following values: \n" +
                "1,2,5,10,20,50,100,200,500,1000");

        int amount = SCANNER.nextInt();
        return amount;
        //addCurrency(amount);
    }

    public int getChosenProduct(){
        int ChosenProduct = SCANNER.nextInt();
        return ChosenProduct;
    }


    public void setDepositPoolWhile(int amount){
        String answer = "y";
        setDepositPool(amount);
        while(answer == "y"){
            //setDepositPool(getDepositPool());
            System.out.println("Your total deposit is: " + depositPool + ". Will you continue deposit? (y/n)");
            SCANNER.nextLine();
            answer = SCANNER.nextLine();
            SCANNER.nextLine();
            //answer="y";

            if(answer.equalsIgnoreCase("y")) addCurrency(getCurrency());

            while(!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")){
                System.out.println("Your answer must to be \"y\" for Yes or \"n\" for Not. Tray again: ");
                SCANNER.nextLine();
                answer = SCANNER.nextLine();
                SCANNER.nextLine();
            }
        }

    }

    @Override
    public boolean addCurrency(int amount) {

        int[] acceptsValues = {1,2,5,10,20,50,100,200,500,1000};

        boolean result = false;

        for(int v : acceptsValues){
            if(v == amount){
                result = true;
                break;
            }

        }

        if(result){
            //setDepositPool(amount);
            setDepositPoolWhile(amount);

        }else{
            System.out.println("Deposit a valid values");
        }

        return result;
    }
/*
    public boolean checkValidValue(int value){
        int[] acceptsValues = {1,2,5,10,20,50,100,200,500,1000};

        boolean result = true;

            for(int v : acceptsValues){
                result = v == value;
            }
            if(!result){
                System.out.println("Deposit a valid values");
            }

        return result;
    }
*/
    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public int request(int id) {
         for(Product p2 : products){
            if(id == p2.getId()){
                if(depositPool > p2.getPrice()){
                    System.out.println("Thanks for your purchase");
                    return p2.getPrice();
                }
                else{
                    System.out.println("You don´t have enough money");
                    return 0;
                }

            }

        }
         System.out.println("product not found");

        return 0;
    }

    @Override
    public int endSession() {
        SCANNER.close();
        depositPool=0;
        return depositPool;
    }

    @Override
    public String TargetDescription(int id) {
        String str;
        for(Product p2 : products){
            if(id == p2.getId()){
                str = "you have chosen a " + p2.productName + ". The Price is " + p2.getPrice() + " and the id is " + p2.getId();
                System.out.println(str);
                return str;
            }
        }
        System.out.println("id not found. Try again!");
        return "";
    }

    @Override
    public String getDescription(Product p) {
        return "Description of the product: " + p.getDescription();
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    public void showProducts(){
        System.out.println("==========Choose a product by inserting the id==============");
        System.out.println("============================================================");
        String leftAlignFormat = "| %-15s| %-15s | %-4d |%n";

        System.out.format("+-----------------+---------------+--------+%n");
        System.out.format("| Product         | Price         | ID     |%n");
        System.out.format("+-----------------+---------------+--------+%n");

        for(Product p : products){
            //System.out.println(p.getProductName() + ". Price " + p.getPrice() + ". Id " + p.getId());
            System.out.format(leftAlignFormat, p.getProductName() , p.getPrice(),p.getId());
        }
        System.out.format("+-----------------+---------------+--------+%n");
    }


}