package com.senac.tads.dsw.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity 

public class funcionario {
    @Id 
    @GeneratedValue 
    private Long id;

    @NotBlank 
    private String nome;

    @PastOrPresent 
    private LocalDate dataAdmissao;

    @NotNull 
    private boolean trabalhoRemoto;

    @ManyToOne 
    @JoinColumn(name = "departamento_id")
    private departamento departamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public boolean isTrabalhoRemoto() {
        return trabalhoRemoto;
    }

    public void setTrabalhoRemoto(boolean trabalhoRemoto) {
        this.trabalhoRemoto = trabalhoRemoto;
    }

    public departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(departamento departamento) {
        this.departamento = departamento;
    }

    

}
