package com.mballen.curso.boot.repository;

import com.mballen.curso.boot.model.Funcionario;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioRepositoryImpl extends AbstractRepository<Funcionario, Long> implements FuncionarioRepository {
}
