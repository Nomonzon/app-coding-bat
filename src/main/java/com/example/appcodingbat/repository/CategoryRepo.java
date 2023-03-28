package com.example.appcodingbat.repository;

import com.example.appcodingbat.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    List<Category> findCategoriesByLanguageId(Long id);

}
