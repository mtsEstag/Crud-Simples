package com.example.Crud.Simples.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Crud.Simples.models.Person;
import com.example.Crud.Simples.services.PersonService;

@RestController
@RequestMapping("person")
public class PersonControl {
    
    @Autowired
    private PersonService personService;

    @PostMapping
    public void save(@RequestBody Person person){
        personService.save(person);
    }
}
