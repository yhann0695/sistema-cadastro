package com.mballen.curso.boot.repository;

import com.mballen.curso.boot.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
