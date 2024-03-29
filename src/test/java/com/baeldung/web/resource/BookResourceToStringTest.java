package com.baeldung.web.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.baeldung.model.Book;

@RunWith(MockitoJUnitRunner.class)
public class BookResourceToStringTest {

    private BookResource bookResource;
    private Book book;

    @Before
    public void setUp() {
        book = mock(Book.class);
        bookResource = new BookResource(book);
    }

    @Test
    public void toStringWithNonNullBook() {
        // Arrange
        String bookString = "Book [isbn=1234567890, title=Sample Book]";
        String resourceSupportString = "ResourceSupport [links=[]]";
        when(book.toString()).thenReturn(bookString);

        // Act
        String result = bookResource.toString();

        // Assert
        String expectedString = "BookResource [book=" + bookString + ", toString()=" + resourceSupportString + "]";
        assertEquals(expectedString, result);
    }

    @Test
    public void toStringWithNullBook() {
        // Arrange
        bookResource = new BookResource(null);
        String resourceSupportString = "ResourceSupport [links=[]]";

        // Act
        String result = bookResource.toString();

        // Assert
        String expectedString = "BookResource [book=null, toString()=" + resourceSupportString + "]";
        assertEquals(expectedString, result);
    }

    @Test
    public void toStringWithEmptyBookResource() {
        // Arrange
        bookResource = new BookResource(book);
        String resourceSupportString = "ResourceSupport [links=[]]";

        // Act
        String result = bookResource.toString();

        // Assert
        String expectedString = "BookResource [book=" + book + ", toString()=" + resourceSupportString + "]";
        assertEquals(expectedString, result);
    }
}
