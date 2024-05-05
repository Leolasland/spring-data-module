package ru.edu.springdata.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.edu.springdata.model.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    private static final String CATEGORY = "Научная фантастика";

    private static final String LANGUAGE = "Русский";
    @Autowired
    BookService bookService;

    @Test
    void getAllBooks() {
        List<Book> books = bookService.getAllBooks();

        assertFalse(books.isEmpty());
    }

    @Test
    void getAllBooksByCategory() {
        List<Book> books = bookService.getAllBooksByCategory(CATEGORY);

        assertFalse(books.isEmpty());
        books.forEach(b -> assertEquals(CATEGORY, b.getCategory()));

        assertDoesNotThrow(() -> bookService.getAllBooksByCategory("SOME CATEGORY"));
    }

    @Test
    void getAllBooksByLanguage() {
        List<Book> books = bookService.getAllBooksByLanguage(LANGUAGE);

        assertFalse(books.isEmpty());
        books.forEach(b -> assertEquals(LANGUAGE, b.getLanguage()));

        assertDoesNotThrow(() -> bookService.getAllBooksByLanguage("SOME LANGUAGE"));
    }

    @Test
    void getBookById() {
        Book book = bookService.getBookById(1L);

        assertNotNull(book);
    }

    @Test
    void saveBook() {
        List<Book> books = bookService.getAllBooksByCategory(CATEGORY);

        bookService.saveBook(book());
        List<Book> result = bookService.getAllBooksByCategory(CATEGORY);

        assertEquals(books.size() + 1, result.size());
    }

    @Test
    void updateBook() {
        Book book = bookService.getBookById(1L);
        String name = book().getName();
        book.setName(name);

        bookService.updateBook(book);
        Book result = bookService.getBookById(1L);
        assertEquals(name, result.getName());
    }

    @Test
    void deleteBookById() {
        Book book = bookService.getBookById(1L);
        assertNotNull(book);

        bookService.deleteBookById(1L);

        Book result = bookService.getBookById(1L);
        assertNull(result);
    }

    private static Book book() {
        return new Book(10L,
                "Белая смерть",
                LANGUAGE,
                CATEGORY);
    }
}