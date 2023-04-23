package com.example.demo1.repositories;

import com.example.demo1.models.Articles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesRepo extends CrudRepository<Articles, Long> {
    List<Articles> findByTitleContainingIgnoreCase(String title);
}