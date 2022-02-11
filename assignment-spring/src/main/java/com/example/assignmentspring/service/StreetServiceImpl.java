package com.example.assignmentspring.service;

import com.example.assignmentspring.entity.Street;
import com.example.assignmentspring.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetServiceImpl implements StreetService{
    @Autowired
    StreetRepository streetRepository;

    @Override
    public Street save(Street street) {
        streetRepository.save(street);
        return street;
    }

    @Override
    public Street update(Street street) {
        streetRepository.save(street);
        return street;
    }

    @Override
    public List<Street> findAll() {
        return streetRepository.findAll();
    }

    @Override
    public Optional<Street> findById(int id) {
        return streetRepository.findById(id);
    }

    @Override
    public Optional<Street> findByName(String name) {
        return streetRepository.findByName(name);
    }
}
