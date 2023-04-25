package com.example.demo1.service;

import com.example.demo1.models.Tour;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {
    private List<Tour> tours = new ArrayList<>();
    private long ID = 0;

    {
        tours.add(new Tour(++ID, "Sary chelek", "On chui. cool place", "Chui", "Elena"));
        tours.add(new Tour(++ID, "Son Kol", "On IK. cool place", "IK", "Alina"));
    }

    public List<Tour> listTours() {
        return tours;
    }

    public void saveTour(Tour tour) {
        tour.setId(++ID);
        tours.add(tour);
    }
    public void deleteTour(Long id){
        tours.removeIf(tour -> tour.getId().equals(id));
    }
}
