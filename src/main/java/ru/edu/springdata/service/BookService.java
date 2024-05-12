package ru.edu.springdata.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.edu.springdata.dto.BookDto;
import ru.edu.springdata.repository.BookRepository;
import ru.edu.springdata.entity.Book;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public List<Book> getAllBooksByLanguage(String language) {
        return repository.findByLanguage(language);
    }

    public Book getBookById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id " + id + "not found"));
    }

    @Transactional
    public void updateBook(Long id, BookDto bookDto) {
        repository.findById(id).ifPresent(book -> {
            book.setTitle(bookDto.title() != null ? bookDto.title() : book.getTitle());
            book.setLanguage(bookDto.language() != null ? bookDto.language() : book.getLanguage());
            repository.save(book);
        });
    }

    @Transactional
    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }
}
