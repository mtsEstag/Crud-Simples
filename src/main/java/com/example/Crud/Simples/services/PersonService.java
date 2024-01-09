package com.example.Crud.Simples.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.Crud.Simples.models.Person;
import com.example.Crud.Simples.repositories.PersonRepository;

import jakarta.persistence.EntityNotFoundException;

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
        try {
            return personRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com o ID: " + id));
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String deleteById(Long id) {

        try {
            if(personRepository.existsById(id)) {
                personRepository.deleteById(id);
                return "success";
            }else {
                return "failed - Entity not found";
            }
        } catch (EmptyResultDataAccessException e) {
            return "failed - Entity not found";
        } catch (Exception e) {
            e.printStackTrace();
            return "failed - Unexpected error";
        }
    }

}
