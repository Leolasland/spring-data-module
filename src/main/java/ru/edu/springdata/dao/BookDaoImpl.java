package ru.edu.springdata.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.edu.springdata.model.Book;

import java.util.List;

@Component
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM books", new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public List<Book> findByLanguage(String language) {
        return jdbcTemplate.query("select * from books where lower(language) ilike ?",
                new BeanPropertyRowMapper<>(Book.class), "%" + language + "%");
    }

    @Override
    public List<Book> findByCategory(String category) {
        return jdbcTemplate.query("select * from books where lower(category) ilike ?",
                new BeanPropertyRowMapper<>(Book.class), "%" + category + "%");
    }

    @Override
    public Book findById(Long id) {
        try {
            return jdbcTemplate.queryForObject("select * from books where id = ?",
                    new BeanPropertyRowMapper<>(Book.class), id);
        } catch (EmptyResultDataAccessException exception) {
            return null;
        }

    }

    @Override
    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO books(name, category, language) VALUES (?, ?, ?)",
                book.getName(), book.getCategory(), book.getLanguage());
    }

    @Override
    public void update(Book book) {
        jdbcTemplate.update("UPDATE books SET name = ?, category = ?, language = ? WHERE id = ?",
                book.getName(), book.getCategory(), book.getLanguage(), book.getId());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
    }
}
