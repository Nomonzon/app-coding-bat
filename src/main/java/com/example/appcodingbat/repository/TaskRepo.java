package com.example.appcodingbat.repository;

import com.example.appcodingbat.entity.Category;
import com.example.appcodingbat.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {

    List<Task> findTasksByCategory_id(Long id);
}
