package ru.edu.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.springdata.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}