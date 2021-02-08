package com.mballen.curso.boot.service;

import com.mballen.curso.boot.model.Funcionario;
import com.mballen.curso.boot.repository.IFuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private IFuncionarioRepository repository;

    public void salvar(Funcionario funcionario) {
        repository.save(funcionario);
    }

    public List<Funcionario> buscarTodos() {
        return repository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return repository.getOne(id);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public List<Funcionario> buscarPorNome(String nome) {
        List<Funcionario> funcionariosList = repository.findByNomeContainsIgnoreCase(nome);
        return funcionariosList;
    }

    public List<Funcionario> buscarPorCargo(Long id) {
        List<Funcionario> funcionarioList = repository.findByCargoId(id);
        return funcionarioList;
    }

    public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
        List<Funcionario> funcionarioList;
        if(entrada != null && saida != null) {
            funcionarioList = repository.findByDataEntradaAndDataSaida(entrada, saida);
        } else if (entrada != null) {
            funcionarioList = repository.findByDataEntrada(entrada);
        } else if (saida != null){
            funcionarioList = repository.findByDataSaida(saida);
        } else {
            return new ArrayList<>();
        }
        return funcionarioList;
    }
}
