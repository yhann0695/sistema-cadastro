package com.mballen.curso.boot.repository;

import com.mballen.curso.boot.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICargoRepository extends JpaRepository<Cargo, Long> {
}
