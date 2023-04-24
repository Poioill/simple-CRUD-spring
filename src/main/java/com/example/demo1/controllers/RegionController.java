package com.example.demo1.controllers;

import com.example.demo1.models.Region;
import com.example.demo1.repositories.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class RegionController {
    @Autowired
    private RegionRepo regionRepo;

    @GetMapping("/region/{id}")
    public String region(@PathVariable(value = "id") long id, Model model){
        if (!regionRepo.existsById(id)){
            return "redirect:/about";
        }
        Optional<Region> regions = regionRepo.findById(id);
        ArrayList<Region> rego = new ArrayList<>();
        regions.ifPresent(rego::add);
        model.addAttribute("rego", rego);
        return "regions";
    }
}
