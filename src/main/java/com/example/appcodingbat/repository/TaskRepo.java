package com.example.appcodingbat.repository;

import com.example.appcodingbat.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}
