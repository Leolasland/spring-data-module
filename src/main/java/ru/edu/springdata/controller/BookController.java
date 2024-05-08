package ru.edu.springdata.controller;

import org.springframework.web.bind.annotation.*;
import ru.edu.springdata.converter.BookConverter;
import ru.edu.springdata.dto.BookDto;
import ru.edu.springdata.entity.Book;
import ru.edu.springdata.service.BookService;
import ru.edu.springdata.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final CategoryService categoryService;

    private final BookConverter bookConverter;

    public BookController(BookService bookService, CategoryService categoryService, BookConverter bookConverter) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.bookConverter = bookConverter;
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks().stream().map(bookConverter::toDto).toList();
    }

    @GetMapping("/category")
    public List<BookDto> getAllBooksByCategory(@RequestParam String category) {
        return categoryService.getAllBooksByCategory(category).stream().map(bookConverter::toDto).toList();
    }

    @GetMapping("/language")
    public List<BookDto> getAllBooksByLanguage(@RequestParam String language) {
        return bookService.getAllBooksByLanguage(language).stream().map(bookConverter::toDto).toList();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        Book bookById = bookService.getBookById(id);
        return bookConverter.toDto(bookById);
    }

    @PatchMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody BookDto book) {
        bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
