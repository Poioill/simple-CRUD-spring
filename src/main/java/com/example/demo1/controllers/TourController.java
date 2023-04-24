package com.example.demo1.controllers;

import com.example.demo1.repositories.TourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TourController {
    @Autowired
    private TourRepo tourRepo;

    @GetMapping("/tours")
    public String tours(Model model){
        return "tours";
    }
}
