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

}
