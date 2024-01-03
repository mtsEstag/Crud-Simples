package com.example.Crud.Simples.services;

import java.util.List;

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

    public List<Person> findAll(){
        List<Person> list = personRepository.findAll();
        return list;
    }

    public Person findById(Long id){
        Person person = personRepository.findById(id).orElse(null);
        return person;
    }

    public void deleteById(Long id){
        personRepository.deleteById(id);
    }
}
