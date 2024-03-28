package com.baeldung.web.resource;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.baeldung.model.Book;

public class CartResourceSetPurchasedTest {
    
    private CartResource cartResource;
    
    @Before
    public void setUp() {
        List<Book> books = new ArrayList<>();
        cartResource = new CartResource(books, false);
    }
    
    @Test
    public void setPurchasedToTrue() {
        cartResource.setPurchased(true);
        assertTrue(cartResource.isPurchased());
    }
    
    @Test
    public void setPurchasedToFalse() {
        cartResource.setPurchased(false);
        assertFalse(cartResource.isPurchased());
    }
    
    @Test
    public void defaultPurchasedStatus() {
        assertFalse(cartResource.isPurchased());
    }
}
