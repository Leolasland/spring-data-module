package ru.edu.springdata.converter;

import org.springframework.stereotype.Component;
import ru.edu.springdata.dto.AddressDto;
import ru.edu.springdata.dto.AuthorDto;
import ru.edu.springdata.dto.BookDto;
import ru.edu.springdata.entity.Address;
import ru.edu.springdata.entity.Author;
import ru.edu.springdata.entity.Book;
import ru.edu.springdata.entity.Category;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookConverter {

    public BookDto toDto(Book entity) {
        return new BookDto(entity.getTitle(), entity.getLanguage(), entity.getCategory().getName(), entity.isActive(),
                entity.getAuthors().stream().map(this::toDto).collect(Collectors.toSet()));
    }

    public AuthorDto toDto(Author entity) {
        return new AuthorDto(entity.getFirstName(), entity.getLastName(), entity.getPhone(),
                new AddressDto(entity.getAddress().getCity(), entity.getAddress().getStreet()));
    }

    public Book toEntity(BookDto dto) {
        Book book = new Book();
        book.setActive(dto.active());
        book.setLanguage(dto.language());
        book.setTitle(dto.title());
        book.setCategory(new Category(null, dto.categoryName(), new ArrayList<>()));
        book.setAuthors(dto.authors().stream().map(a -> toEntity(a, book)).collect(Collectors.toSet()));
        return book;
    }

    public Author toEntity(AuthorDto dto, Book book) {
        Author author = new Author();
        author.setFirstName(dto.firstName());
        author.setLastName(dto.lastName());
        author.setPhone(dto.phone());
        author.setBooks(Set.of(book));
        author.setAddress(new Address(null, dto.address().city(), dto.address().street(), author));
        return author;
    }
}
