package com.mballen.curso.boot.repository;

import com.mballen.curso.boot.model.Cargo;
import org.springframework.stereotype.Repository;

@Repository
public class CargoRepositoryImpl extends AbstractRepository<Cargo, Long> implements CargoRepository{
}
