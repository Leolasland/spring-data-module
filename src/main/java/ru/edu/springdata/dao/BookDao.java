package ru.edu.springdata.dao;

import ru.edu.springdata.model.Book;

import java.util.List;

public interface BookDao {

    List<Book> findAll();

    List<Book> findByLanguage(String language);

    List<Book> findByCategory(String category);

    Book findById(Long id);

    void save(Book book);

    void update(Book book);

    void deleteById(Long id);
}
