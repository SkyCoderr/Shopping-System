package shop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This is a class that tests three classes for Ex2: Product, MultiBuyProduct and ShoppingCart. It tests
 * every method in these three classes.
 *
 * @author Haojie Chen
 * @version 2018-12-05
 */

public class MyTest {

    Product milk = new Product("Milk", 0.9, 2);
    Product tea = new Product("Tea", 2.5, 2);
    Product tissue = new Product("Tissue", 1, 5);

    MultiBuyProduct cup = new MultiBuyProduct("Cup", 3, 2, 2, 25);
    MultiBuyProduct pen = new MultiBuyProduct("Pen", 0.8, 10, 5, 30);
    MultiBuyProduct book = new MultiBuyProduct("Book", 10, 1, 2, 10);

    ShoppingCart cart = new ShoppingCart();

    final double tolerance = 0.0001;

    // It tests the getter for variable name in class Product.
    @Test
    public void test1(){
        String expected = "Milk";
        String actual = milk.getName();
        assertTrue(expected.equals(actual));
    }

    // It tests the getter for variable price in class Product.
    @Test
    public void test2(){
        double expected = 0.9;
        double actual = milk.getPrice();
        assertEquals(expected, actual, tolerance);
    }

    // It tests the getter for variable quantity in class Product.
    @Test
    public void test3(){
        int expected = 2;
        int actual = milk.getQuantity();
        assertEquals(expected, actual);
    }

    // It tests the method setQuantity() in class Product.
    @Test
    public void test4(){

        int expected = 2;
        int actual = milk.getQuantity();
        assertEquals(expected, actual);

        milk.setQuantity(3);
        actual = milk.getQuantity();
        assertFalse(expected==actual);

        expected = 3;
        assertEquals(expected, actual);
    }

    // It tests the method getTotalPrice() in class Product.
    @Test
    public void test5(){
        double expected = 1.8;
        double actual = milk.getTotalPrice();
        assertEquals(expected, actual, tolerance);

        // book is a multi buy product, but it doesn't satisfy the discounted quantity criteria.
        expected = 10;
        actual = book.getTotalPrice();
        assertEquals(expected, actual, tolerance);

        // cup is a multi buy product, and it satisfies the discounted quantity criteria.
        expected = 4.5;
        actual = cup.getTotalPrice();
        assertEquals(expected, actual, tolerance);

        expected = 5;
        actual = tissue.getTotalPrice();
        assertEquals(expected, actual,tolerance);

        expected = 5.6;
        actual = pen.getTotalPrice();
        assertEquals(expected, actual, tolerance);

        expected = 10;
        actual = book.getTotalPrice();
        assertEquals(expected, actual, tolerance);
    }

    // It tests the method getProducts(), getTotal() and add() in class ShoppingCart.
    @Test
    public void test6(){
        // tests the getter for products
        int expected = 0;
        int actual = cart.getProducts().size();
        assertEquals(expected, actual);

        // add products to cart to see if the array list expands, tests add().
        cart.add(tea);
        cart.add(tissue);
        expected = 2;
        actual = cart.getProducts().size();
        assertEquals(expected, actual);

        // add a product that has been added before to see if the array list still expands, tests add().
        cart.add(tea);
        actual = cart.getProducts().size();
        assertEquals(expected, actual);
    }

    // It tests the method getTotal() in class ShoppingCart.
    @Test
    public void test7(){
        // add products to the cart and see if the sum of prices of all products is equal to the cart.
        cart.add(tissue);
        cart.add(pen);
        cart.add(book);
        double expectedTotal = tissue.getTotalPrice() + pen.getTotalPrice() + book.getTotalPrice();
        double actualTotal = cart.getTotal();
        assertEquals(expectedTotal, actualTotal, tolerance);

        // book didn't have a discount before, now it does, tests if the getTotal works for the change.
        cart.add(book);
        expectedTotal = 28.6;
        actualTotal = cart.getTotal();
        assertEquals(expectedTotal, actualTotal, tolerance);
    }

    // It displays the bill for the cart.
    @Test
    public void test8(){
        cart.add(milk);
        cart.add(tissue);
        cart.add(pen);
        cart.add(book);
        cart.add(tea);
        cart.add(cup);
        cart.add(tea);
        System.out.print(cart.toString());
    }

}
