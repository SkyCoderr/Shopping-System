package shop;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class is used to manage all product objects from class Product and MultiBuyProduct. It can
 * add them to its field variable, which is an array list, get their total price and have have all
 * the prices included in its own toString method.
 *
 * @author Haojie Chen
 * @version 2018-12-05
 */

public class ShoppingCart {

    private ArrayList<Product> products;

    /**
     * Constructor of the class. When initialised, its array list would be empty.
     */
    public ShoppingCart(){
        products = new ArrayList<Product>(5);
    }

    /**
     * Getter for field variable products.
     * @return ArrayList<Product>, used to store its product objects.
     */
    public ArrayList<Product> getProducts(){
        return products;
    }

    /**
     * Adds product objects to its array list. However, if the same product has been
     * added before, it simply add its quantity to the same product without adding
     * another object.
     * @param p Type Product, the product that needs to be added to the shopping cart.
     */
    public void add(Product p){
        Boolean duplication = false;
        for (Product el: products) {
            if (el.getName().equals(p.getName()) && el.getPrice() == p.getPrice()) {
                duplication = true;
                el.setQuantity(el.getQuantity() + p.getQuantity());
                break;
            }
        }
        if (duplication == false){
            products.add(p);
        }
    }

    /**
     * Getter for the total price of all products in the shopping cart. It calls the
     * getTotalPrice() method for each element and sum their prices together.
     * @return Type double, the total price of all products.
     */
    public double getTotal(){
        double total = 0;
        for (Product el: products){
            total = total + el.getTotalPrice();
        }
        return total;
    }

    /**
     * toString method of the class. It calls the toString() method for each element,
     * and combine them together to form the bill.
     * @return Type String, the bill of all products.
     */
    public String toString(){
        String str = "";
        for (Product el: products){
            str += el.toString();
        }
        str = str + String.format("%36s%s%n", " ", "-----------------") +
                String.format("%33s%s%6s%n", " ",  "TOTAL GBP     ", getTotal());
        return str;
    }
}
