package shop;

import java.text.DecimalFormat;

/**
 * This class is the superclass of class MultiBuyProduct, it defines the basic methods of a product,
 * and it has its own toString method.
 *
 * @author Haojie Chen
 * @version 2018-12-05
 */

public class Product {

    private String name;
    private double price;
    private int quantity;

    DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Constructor of the class.
     * @param name Type String, passes name to its field variable.
     * @param price Type double, passes price to its field variable.
     * @param quantity Type int, passes quantity to its field variabel.
     */
    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Getter for field variable name
     * @return Type String, name of the product.
     */
    public String getName(){
        return name;
    }

    /**
     * Getter for field variable price.
     * @return Type double, price of the variable.
     */
    public double getPrice(){
        return price;
    }

    /**
     * Getter for field variable quantity.
     * @return Type int, quantity of the variable.
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Setter for field variable quantity.
     * @param quantity Type int, the value of quantity to be set.
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * Getter for the total price of this product.
     * @return Type double, the total price of this product.
     */
    public double getTotalPrice(){
        return getPrice() * getQuantity();
    }

    /**
     * toString method of the product, includes all necessary information about this
     * product in String format.
     * @return Type String, one record in bill of all products.
     */
    public String toString(){
        return String.format("%2s%-15s%5s%-15s%s%6s%n", String.valueOf(getQuantity()), " * GBP",
                String.valueOf(df.format(getPrice())), " " + getName(), "= GBP     ", df.format(getTotalPrice()));
    }
}
