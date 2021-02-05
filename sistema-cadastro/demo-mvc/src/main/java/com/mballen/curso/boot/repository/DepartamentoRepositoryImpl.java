package com.mballen.curso.boot.repository;

import com.mballen.curso.boot.model.AbstractEntity;
import com.mballen.curso.boot.model.Departamento;
import org.springframework.stereotype.Repository;

@Repository
public class DepartamentoRepositoryImpl extends AbstractRepository<Departamento, Long> implements DepartamentoRepository {}

