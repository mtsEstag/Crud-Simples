package com.example.Crud.Simples.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Crud.Simples.models.Person;


public interface PersonRepository extends JpaRepository<Person, Long>{
    
    boolean existsByRegistration(String registration);
}
