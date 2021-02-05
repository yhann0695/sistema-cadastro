package com.mballen.curso.boot.service;

import com.mballen.curso.boot.model.Funcionario;
import com.mballen.curso.boot.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService{

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public void salvar(Funcionario funcionario) {
        repository.save(funcionario);
    }

    @Override
    public void editar(Funcionario funcionario) {
        repository.update(funcionario);
    }

    @Override
    public void excluir(Long id) {
        repository.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public Funcionario buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Funcionario> buscarTodos() {
        return repository.findAll();
    }
}
