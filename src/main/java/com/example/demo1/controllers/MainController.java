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
}
