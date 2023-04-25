package com.example.demo1.controllers;

import com.example.demo1.models.Tour;
import com.example.demo1.repositories.TourRepo;
import com.example.demo1.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TourController {
    private final TourService tourService;

    @GetMapping("/tours")
    public String tours(Model model){
        model.addAttribute("dada", tourService.listTours());
        return "tours";
    }
    @PostMapping("/tour/add")
    public String addTour(Tour tour){
        tourService.saveTour(tour);
        return "tours";
    }
}
