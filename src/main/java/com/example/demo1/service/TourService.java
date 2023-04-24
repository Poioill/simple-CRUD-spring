package com.example.demo1.service;

import com.example.demo1.models.Tour;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {
    private List<Tour> tours = new ArrayList<>();

    {
        tours.add(new Tour(1L, "Sary chelek", "On chui. cool place", "Chui", "Elena"));
        tours.add(new Tour(2L, "Son Kol", "On IK. cool place", "IK", "Alina"));
    }
    public List<Tour> listTours(){
        return tours;
    }
    public void saveTour(Tour tour){
        tours.add(tour);
    }


}
