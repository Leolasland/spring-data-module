package ru.edu.springdata.dto;

import ru.edu.springdata.entity.Book;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link ru.edu.springdata.entity.Book} entity
 */
public record BookDto(String title, String language, String categoryName, boolean active,
                      Set<AuthorDto> authors) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto entity = (BookDto) o;
        return Objects.equals(this.title, entity.title) &&
                Objects.equals(this.language, entity.language) &&
                Objects.equals(this.categoryName, entity.categoryName) &&
                Objects.equals(this.active, entity.active) &&
                Objects.equals(this.authors, entity.authors);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "title = " + title + ", " +
                "language = " + language + ", " +
                "categoryName = " + categoryName + ", " +
                "active = " + active + ", " +
                "authors = " + authors + ")";
    }
}