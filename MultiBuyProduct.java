package shop;

/**
 * This class is an subclass of class Product. It has all the methods in class Product, and some
 * methods that class Product doesn't have. Besides, it overrides some of class Product's methods,
 * like method getTotalPrice() and method toString().
 *
 * @author Haojie Chen
 * @version 2018-12-05
 */

public class MultiBuyProduct extends Product {

    private int minDiscountedQuantity;
    private int discountedPercent;

    /**
     * Constructor of the class, with several field variables passed to its superclass.
     * @param name Type String, passed to its superclass.
     * @param price Type double, passed to its superclass.
     * @param quantity Type int, passed to its superclass.
     * @param minDiscountedQuantity Type int, passed to its field variable.
     * @param discountedPercent Type int, passed to its field variable.
     */
    public MultiBuyProduct(String name, double price, int quantity, int minDiscountedQuantity, int discountedPercent){
        super(name, price, quantity);
        this.minDiscountedQuantity = minDiscountedQuantity;
        this.discountedPercent = discountedPercent;
    }

    /**
     * Getter for field variable minDiscountedQuantity.
     * @return Type int, the minimum quantity that satisfies the discount.
     */
    public int getMinDiscountedQuantity(){
        return minDiscountedQuantity;
    }

    /**
     * Getter for field variable discountedPercent.
     * @return Type int, the discounted percentage of the product.
     */
    public int getDiscountedPercent(){
        return discountedPercent;
    }

    /**
     * Getter for the total price. If it satisfies discount requirements, a percentage
     * of discount would be applied to the total price.
     * @return Type double, the total price of this product.
     */
    @Override
    public double getTotalPrice(){
        if (getQuantity() >= getMinDiscountedQuantity()){
            return super.getTotalPrice() * (1 - getDiscountedPercent()/100.0);
        } else{
            return super.getTotalPrice();
        }
    }

    /**
     * toString method of the class includes all necessary information about this
     * product in String format.
     * @return Type String, one record in bill of all products.
     */
    @Override
    public String toString(){
        if (getQuantity() >= getMinDiscountedQuantity()){
            return String.format("%s%s%s%s%n", super.toString(), "  (Multibuy Discount: GBP: ",
                    df.format(super.getTotalPrice() * getDiscountedPercent() / 100), ")");
        } else{
            return super.toString();
        }
    }
}
