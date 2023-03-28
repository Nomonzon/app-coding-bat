package com.example.appcodingbat.controller;


import com.example.appcodingbat.entity.Category;
import com.example.appcodingbat.repository.CategoryRepo;
import com.example.appcodingbat.repository.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private LanguageRepo languageRepo;

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("languages", languageRepo.findAll());
        return "index";
    }


    @GetMapping("/category/{id}")
    public String getCategories(@PathVariable Long id, Model model) {
        model.addAttribute("categories", categoryRepo.findCategoriesByLanguageId(id));
        return "category";
    }


}
