package com.senac.tads.dsw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.tads.dsw.model.funcionario;

public interface funcionarioRepository extends JpaRepository<funcionario, Long> {
    
}
