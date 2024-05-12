package ru.edu.springdata.service;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.edu.springdata.dto.BookDto;
import ru.edu.springdata.entity.Book;
import ru.edu.springdata.entity.Category;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    private static final String LANGUAGE = "Русский";
    @Autowired
    BookService bookService;

    @Test
    void getAllBooks() {
        List<Book> books = bookService.getAllBooks();

        assertFalse(books.isEmpty());
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
    void updateBook() {
        Book book = bookService.getBookById(1L);
        String name = book().title();
        book.setTitle(name);

        bookService.updateBook(1L, book());
        Book result = bookService.getBookById(1L);
        assertEquals(name, result.getTitle());
    }

    @Test
    void deleteBookById() {
        Book book = bookService.getBookById(1L);
        assertNotNull(book);

        bookService.deleteBookById(1L);

        assertThrows(EntityNotFoundException.class, () -> bookService.getBookById(1L));
    }

    private static BookDto book() {
        return new BookDto("Белая смерть", LANGUAGE, "SOME CATEGORY",
                true, new HashSet<>());
    }
}