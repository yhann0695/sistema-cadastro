package com.mballen.curso.boot.repository;

import com.mballen.curso.boot.model.Cargo;
import com.mballen.curso.boot.model.Funcionario;

import java.util.List;

public interface FuncionarioRepository {

    void save(Funcionario funcioanrio);

    void update(Funcionario funcioanrio);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();
}
