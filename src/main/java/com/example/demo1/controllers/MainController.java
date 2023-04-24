package com.example.demo1.controllers;

import com.example.demo1.models.Region;
import com.example.demo1.models.Tour;
import com.example.demo1.repositories.RegionRepo;
import com.example.demo1.repositories.TourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private TourRepo tourRepo;
    @Autowired
    private RegionRepo regionRepo;

    @GetMapping("/")
    public String main(Model model){
        Iterable<Region> rego = regionRepo.findAll();
        model.addAttribute("rego", rego);
        return "main";
    }
    @GetMapping("/tours")
    public String tours(Model model){
        Iterable<Tour> tours = tourRepo.findAll();
        model.addAttribute("tt", tours);
        return "tours";
    }
    @PostMapping("/tours")
    public String toursPost(@RequestParam String text, Model model){
        Tour tour = new Tour(text);
        tourRepo.save(tour);
        return "redirect:/tours";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String text, Model model){
        Iterable<Tour> tours;
        if (text != null && !text.isEmpty()){
            tours = tourRepo.findByText(text);
        } else {
            tours = tourRepo.findAll();
        }
        model.addAttribute("tt", tours);
        return "/tours";
    }

    @GetMapping("/about")
    public String about(Model model){
        return "about";
    }



    @PostMapping("/tours/{id}/del")
    public String remove(@PathVariable(value = "id") long id, Model model){
        Tour tour = tourRepo.findById(id).orElseThrow();
        tourRepo.delete(tour);
        return "redirect:/tours";
    }
}
