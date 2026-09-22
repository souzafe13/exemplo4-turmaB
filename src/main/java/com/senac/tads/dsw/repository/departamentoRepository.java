package com.senac.tads.dsw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senac.tads.dsw.model.departamento;

public interface departamentoRepository extends JpaRepository<departamento, Long> {
    
}
