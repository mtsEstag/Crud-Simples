package com.example.Crud.Simples.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Crud.Simples.models.Mensagem;
import com.example.Crud.Simples.models.Person;
import com.example.Crud.Simples.services.PersonService;

@RestController
@RequestMapping("person")
public class PersonControl {

    @Autowired
    private PersonService personService;

    @Autowired
    private Mensagem mensagem;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Person person) {

        boolean saves = personService.save(person);

        if (saves) {
            mensagem.setMensagem("Salvo com sucesso");
            return ResponseEntity.ok().body(mensagem);
        } else {
            mensagem.setMensagem("Houve erros ao salvar");
            return ResponseEntity.badRequest().body(mensagem);
        }

    }

    @GetMapping
    public List<Person> findAll() {
        List<Person> lista = personService.findAll();
        return lista;
    }

    @GetMapping("{id}")
    public Person findById(@PathVariable Long id) {
        Person person = personService.findById(id);
        return person;
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        personService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody Person person) {
        personService.save(person);
    }

}
