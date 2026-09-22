package com.senac.tads.dsw.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
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

    @PutMapping ("/{id}")
    public departamento atualizar(@PathVariable Long id, @RequestBody @Valid departamento departamentoAtualizado) {
        return repository.findById(id)
            .map(departamentoExistente -> {
                departamentoExistente.setNome(departamentoAtualizado.getNome());
                departamentoExistente.setOrcamento(departamentoAtualizado.getOrcamento());
                return repository.save(departamentoExistente);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado"));
                        
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado");
        }
        repository.deleteById(id);
    }
} 
