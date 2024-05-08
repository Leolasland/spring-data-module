package ru.edu.springdata.service;

import org.springframework.stereotype.Service;
import ru.edu.springdata.entity.Book;
import ru.edu.springdata.entity.Category;
import ru.edu.springdata.repository.CategoryRepository;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Book> getAllBooksByCategory(String category) {
        return categoryRepository.findCategoryByName(category)
                .map(Category::getBooks).orElse(Collections.emptyList());
    }
}
