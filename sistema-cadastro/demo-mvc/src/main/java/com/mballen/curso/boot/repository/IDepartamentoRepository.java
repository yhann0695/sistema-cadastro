package com.mballen.curso.boot.repository;

import com.mballen.curso.boot.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartamentoRepository extends JpaRepository<Departamento, Long> {
}
