package com.mballen.curso.boot.repository;

import com.mballen.curso.boot.model.Cargo;

import java.util.List;

public interface CargoRepository {

    void save(Cargo cargo);

    void update(Cargo cargo);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();
}
