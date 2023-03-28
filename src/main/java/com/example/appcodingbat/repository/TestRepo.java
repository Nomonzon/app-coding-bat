package com.example.appcodingbat.repository;

import com.example.appcodingbat.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test,Long> {

}
