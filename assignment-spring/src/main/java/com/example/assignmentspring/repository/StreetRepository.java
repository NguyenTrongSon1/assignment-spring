package com.example.assignmentspring.repository;

import com.example.assignmentspring.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StreetRepository extends JpaRepository<Street,Integer> {

    Optional<Street> findByName(String name);
}
