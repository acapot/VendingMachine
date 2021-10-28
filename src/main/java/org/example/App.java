package org.example;

import org.example.model.*;

import java.util.*;

//import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        PSnack PotatoChips = new PSnack(1,10,"Potato chips","Delicious Potato chips");
        PSnack SaltedPeanuts = new PSnack(2,16,"Salted Peanuts","Delicious Salted peanuts");
        PSnack Popcorn = new PSnack(3,13,"Popcorn","Delicious Popcorn");
        PSnack Pretzels = new PSnack(4,25,"Pretzels","Delicious Pretzels");

        PDrink CocaCola = new PDrink(5,15,"CocaCola","Delicious CocaCola",false);
        PDrink Fanta = new PDrink(6,13,"Fanta","Delicious Fanta",false);
        PDrink Beer = new PDrink(7,21,"Beer","Delicious Beer",true);
        PDrink Sprite = new PDrink(8,11,"Sprite","Delicious Sprite",false);

        PFruit Banana = new PFruit(9,9,"Banana","Delicious Banana");
        PFruit Apple = new PFruit(10,23,"Apple","Delicious Apple");
        PFruit Pear = new PFruit(11,19,"Pear","Delicious Pear");
        PFruit Kiwi = new PFruit(12,33,"Kiwi","Delicious Kiwi");

        List<Product> p = new ArrayList<Product>(){
            {
                add(PotatoChips);
                add(SaltedPeanuts);
                add(Popcorn);
                add(Pretzels);
                add(CocaCola);
                add(Fanta);
                add(Beer);
                add(Sprite);
                add(Banana);
                add(Apple);
                add(Pear);
                add(Kiwi);

            }
        };

       VendingMachineImpl VM = new VendingMachineImpl(p);
       VM.run();
    }



}
