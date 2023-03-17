package com.example.appcodingbat.controller;


import com.example.appcodingbat.repository.TaskRepo;
import com.example.appcodingbat.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class SolutionController {


    @Autowired
    private SolutionService solutionService;


    @Autowired
    private TaskRepo taskRepo;

    @GetMapping("/")
    public String getSolutionPage(Model model) {
        return "solution";
    }

    @PostMapping("/submit")
    public String getSolution(@RequestParam String solution) throws IOException {
        List<String> test = List.of("1,2:3",
                "2,4:6",
                "3,5:8",
                "2,2:4",
                "1,2:3"
        );
        for (String s : test) {
            System.out.println(solutionService.evaluate(solution, s));
        }
        return "solution";
    }

}
