package ru.edu.springdata.service;

import org.springframework.stereotype.Service;
import ru.edu.springdata.dao.BookDao;
import ru.edu.springdata.model.Book;

import java.util.List;

@Service
public class BookService {

    private final BookDao dao;

    public BookService(BookDao dao) {
        this.dao = dao;
    }

    public List<Book> getAllBooks() {
        return dao.findAll();
    }

    public List<Book> getAllBooksByCategory(String category) {
        return dao.findByCategory(category);
    }

    public List<Book> getAllBooksByLanguage(String language) {
        return dao.findByLanguage(language);
    }

    public Book getBookById(Long id) {
        return dao.findById(id);
    }

    public void saveBook(Book book) {
        dao.save(book);
    }

    public void updateBook(Book book) {
        dao.update(book);
    }

    public void deleteBookById(Long id) {
        dao.deleteById(id);
    }
}
