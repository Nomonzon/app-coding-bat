package com.example.appcodingbat.controller;
import com.example.appcodingbat.entity.Task;
import com.example.appcodingbat.repository.TaskRepo;
import com.example.appcodingbat.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Controller
public class SolutionController {


    @Autowired
    private SolutionService solutionService;


    @Autowired
    private TaskRepo taskRepo;

    @GetMapping("/taskSolution/{id}")
    public String getTask(@PathVariable Long id, Model model){
        Optional<Task> optionalTask = taskRepo.findById(id);
        optionalTask.ifPresent(task -> model.addAttribute("task", task));
//        model.addAttribute("test", optionalTask.get().getTest());
        return "solution";
    }

}


