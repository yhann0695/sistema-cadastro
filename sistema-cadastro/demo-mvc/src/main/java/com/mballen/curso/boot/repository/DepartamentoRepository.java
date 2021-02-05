package com.mballen.curso.boot.repository;

import com.mballen.curso.boot.model.Departamento;

import java.util.List;

public interface DepartamentoRepository {

    void save(Departamento departamento);

    void update(Departamento departamento);

    void delete(Long id);

    Departamento findById(Long id);

    List<Departamento> findAll();
}
