package com.example.Crud.Simples.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Crud.Simples.models.Person;
import com.example.Crud.Simples.repositories.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    public void save(Person person){
        personRepository.save(person);
    }
}
