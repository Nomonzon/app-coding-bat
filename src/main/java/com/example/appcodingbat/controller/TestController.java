package com.example.appcodingbat.controller;

import com.example.appcodingbat.entity.Test;
import com.example.appcodingbat.repository.TestRepo;
import com.example.appcodingbat.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TestController {

    @Autowired
    private TestRepo testRepo;

    @Autowired
    private SolutionService solutionService;


    @GetMapping("/tasks")
    public String getTest(Model model) {
        model.addAttribute("tests", testRepo.findAll());
        return "tasks";
    }

    @PostMapping("/submit/{id}")
    public String solve(@PathVariable Long id, @RequestParam String solution, Model model) throws IOException {
        Optional<Test> testOptional = testRepo.findById(id);
        List<List<Boolean>> list = new ArrayList<>();
        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            for (String s : test.getTest().split(";")) {
                list.add(solutionService.evaluate(solution, s));
            }
            model.addAttribute("tests", test.getTest().split(";"));
            model.addAttribute("answers", list);
        }
        return "success";
    }
}
