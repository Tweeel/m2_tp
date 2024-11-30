package com.example.tp.tp2;

import com.example.tp.verification.tp2.Product;
import com.example.tp.verification.tp2.ProductNotFoundException;
import com.example.tp.verification.tp2.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ShoppingCartTest {

    ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    public void constructor_isCreatingEmptyCart() {
        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void addItem_isAddingItemToCart() {
        Product product1 = new Product("Laptop", 1.1000);
        Product product2 = new Product("Mouse", 0.5000);
        cart.addItem(product1);
        assertEquals(1, cart.getItemCount());
        cart.addItem(product2);
        assertEquals(2, cart.getItemCount());
    }

    @Test
    public void addItem_isAddingItemToCartWithCorrectPrice() {
        Product product1 = new Product("Laptop", 1.1000);
        Product product2 = new Product("Mouse", 0.5000);
        cart.addItem(product1);
        assertEquals(1.1000, cart.getBalance());
        cart.addItem(product2);
        assertEquals(1.6000, cart.getBalance());
    }

    @Test
    public void removeItem_isRemovingItemFromCart() throws ProductNotFoundException {
        Product product1 = new Product("Laptop", 1.1000);
        Product product2 = new Product("Mouse", 0.5000);
        cart.addItem(product1);
        cart.addItem(product2);
        assertEquals(2, cart.getItemCount());
        cart.removeItem(product1);
        assertEquals(1, cart.getItemCount());
        assertEquals(0.5000, cart.getBalance());
    }

    @Test
    public void removeItem_isThrowingExceptionWhenItemNotFound() {
        Product product1 = new Product("Laptop", 1.1000);
        Product product2 = new Product("Mouse", 0.5000);
        cart.addItem(product1);
        cart.addItem(product2);
        assertEquals(2, cart.getItemCount());
        try {
            cart.removeItem(new Product("Keyboard", 0.7000));
            fail("ProductNotFoundException should have been thrown");
        } catch (ProductNotFoundException e) {
            assertEquals(2, cart.getItemCount());
        }
    }

    @Test
    public void empty_isEmptyingCart() {
        Product product1 = new Product("Laptop", 1.1000);
        Product product2 = new Product("Mouse", 0.5000);
        cart.addItem(product1);
        cart.addItem(product2);
        assertEquals(2, cart.getItemCount());
        cart.empty();
        assertEquals(0, cart.getItemCount());
        assertEquals(0.0000, cart.getBalance());
    }
}
