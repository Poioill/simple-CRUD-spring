package com.example.demo1.controllers;

import com.example.demo1.models.Articles;
import com.example.demo1.repositories.ArticlesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ArticlesController {
    @Autowired
    private ArticlesRepo articlesRepo;

    @PostMapping("/articles")
    public String articles(@RequestParam String title, @RequestParam String text, Model model){
        Articles art = new Articles(title, text);
        articlesRepo.save(art);
        return "redirect:/articles";
    }
    @GetMapping("/articles")
    public String articles(Model model){
        Iterable<Articles> art = articlesRepo.findAll();
        model.addAttribute("art", art);
        return "articles";
    }
    @GetMapping("/articles/{id}")
    public String artReadMore(@PathVariable(value = "id") long id, Model model){
        Articles art = articlesRepo.findById(id).orElseThrow();
        model.addAttribute("art", art);
        return "/art/article-read";
    }
    @PostMapping("search")
    public String search(@RequestParam String title, Model model){
        Iterable<Articles> art;
        if (title != null && !title.isEmpty()){
            art = articlesRepo.findByTitleContainingIgnoreCase(title);
        } else {
            art = articlesRepo.findAll();
        }
        model.addAttribute("art", art);
        return "/articles";
    }
    @PostMapping("articles/{id}/delete")
    public String deleteArt(@PathVariable(value = "id") long id, Model model){
        Articles art = articlesRepo.findById(id).orElseThrow();
        articlesRepo.delete(art);
        return "redirect:/articles";
    }
    @GetMapping("/articles/{id}/edit")
    public String artEdit(@PathVariable(value = "id") long id, Model model) {
        Optional<Articles> art = articlesRepo.findById(id);
        ArrayList<Articles> res = new ArrayList<>();
        art.ifPresent(res::add);
        model.addAttribute("art", res);
        return "/art/article-edit";
    }
    @PostMapping("/articles/{id}/edit")
    public String artUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String text, Model model) {
        Articles art = articlesRepo.findById(id).orElseThrow();
        art.setTitle(title);
        art.setDescription(text);
        articlesRepo.save(art);
        return "redirect:/articles/{id}";
    }


}
