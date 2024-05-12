package ru.edu.springdata.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.edu.springdata.entity.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryServiceTest {

    private static final String CATEGORY = "Научная фантастика";

    @Autowired
    CategoryService categoryService;

    @Test
    @Transactional
    void getAllBooksByCategory() {
        List<Book> books = categoryService.getAllBooksByCategory(CATEGORY);

        assertFalse(books.isEmpty());
        books.forEach(b -> assertEquals(CATEGORY, b.getCategory().getName()));

        assertDoesNotThrow(() -> categoryService.getAllBooksByCategory("SOME CATEGORY"));
    }
}
