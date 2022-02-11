package com.example.assignmentspring.service;

import com.example.assignmentspring.entity.Street;

import java.util.List;
import java.util.Optional;

public interface StreetService {
    Street save(Street street);

    Street update(Street street);

    List<Street> findAll();

    Optional<Street> findById(int id);

    Optional<Street> findByName(String name);
}
