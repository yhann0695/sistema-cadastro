package com.mballen.curso.boot.repository;

import com.mballen.curso.boot.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByNomeContainsIgnoreCase(String nome);

    List<Funcionario> findByCargoId(Long id);

    List<Funcionario> findByDataEntradaAndDataSaida(LocalDate entrada, LocalDate saida);

    List<Funcionario> findByDataEntrada(LocalDate entrada);

    List<Funcionario> findByDataSaida(LocalDate saida);
}
