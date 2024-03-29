package com.baeldung.web.resource;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.baeldung.model.Book;

@RunWith(Parameterized.class)
public class CartResourceSetPurchasedTest {

    private CartResource cartResource;
    private boolean inputPurchased;
    private boolean expectedPurchased;

    public CartResourceSetPurchasedTest(boolean inputPurchased, boolean expectedPurchased) {
        this.inputPurchased = inputPurchased;
        this.expectedPurchased = expectedPurchased;
    }

    @Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { true, true },
            { false, false }
        });
    }

    @Before
    public void setUp() {
        List<Book> books = Arrays.asList(new Book("Book 1"), new Book("Book 2"));
        cartResource = new CartResource(books, false);
    }

    @Test
    public void setPurchasedTest() {
        cartResource.setPurchased(inputPurchased);
        boolean actualPurchased = cartResource.isPurchased();
        if (expectedPurchased) {
            assertTrue(actualPurchased);
        } else {
            assertFalse(actualPurchased);
        }
    }

    @Test
    public void verifyDefaultPurchasedStatus() {
        assertFalse(cartResource.isPurchased());
    }

    @Test
    public void verifyPurchasedStatusAfterMultipleInvocations() {
        cartResource.setPurchased(true);
        cartResource.setPurchased(false);
        cartResource.setPurchased(true);
        assertTrue(cartResource.isPurchased());
    }
}
