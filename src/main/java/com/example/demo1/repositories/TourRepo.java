package com.example.demo1.repositories;


import com.example.demo1.models.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepo extends CrudRepository<Tour, Long> {
    List<Tour> findByText(String text);
}
