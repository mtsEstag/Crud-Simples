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

    public boolean save(Person person) {

        boolean exist = personRepository.existsByRegistration(person.getRegistration());

        System.out.println(exist);

        if (!exist) {
            personRepository.save(person);
            return true;
        } else {
            return false;
        }
    }

    public List<Person> findAll() {

        List<Person> list = personRepository.findAll();
        return list;
    }

    public Person findById(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        return person;
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
