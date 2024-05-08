package ru.edu.springdata.controller;

import org.springframework.web.bind.annotation.*;
import ru.edu.springdata.model.Book;
import ru.edu.springdata.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/category")
    public List<Book> getAllBooksByCategory(@RequestParam String category) {
        return bookService.getAllBooksByCategory(category);
    }

    @GetMapping("/language")
    public List<Book> getAllBooksByLanguage(@RequestParam String language) {
        return bookService.getAllBooksByLanguage(language);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public void saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @PatchMapping
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
