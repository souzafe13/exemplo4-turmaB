package com.senac.tads.dsw.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.senac.tads.dsw.model.departamento;
import com.senac.tads.dsw.repository.departamentoRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/api/departamentos")

public class departamentoController {
    
    private final departamentoRepository repository;

    public departamentoController(departamentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping 
    public List<departamento> listarTodos() {
        return repository.findAll(); // retorna 200 ok por padrão
    }
    
    @PostMapping 
    @ResponseStatus (HttpStatus.CREATED)
    public departamento criar(@RequestBody @Valid departamento novoDepartamento) {
        return repository.save(novoDepartamento); // retorna 201 created
    }
}
