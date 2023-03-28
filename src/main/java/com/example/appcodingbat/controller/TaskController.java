package com.example.appcodingbat.controller;

import com.example.appcodingbat.entity.Category;
import com.example.appcodingbat.repository.CategoryRepo;
import com.example.appcodingbat.repository.TaskRepo;
import com.example.appcodingbat.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private TestRepo testRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    @GetMapping("/task/{id}")
    public String getTasks(@PathVariable Long id, Model model) {

        Optional<Category> optionalCategory = categoryRepo.findById(id);
        optionalCategory.ifPresent(category -> model.addAttribute("category", category));
        model.addAttribute("tasks", taskRepo.findTasksByCategory_id(id));
        return "tasks";
    }


}
