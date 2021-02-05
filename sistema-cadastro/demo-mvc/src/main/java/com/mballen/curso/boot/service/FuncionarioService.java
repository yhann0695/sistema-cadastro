package com.mballen.curso.boot.service;

import com.mballen.curso.boot.model.Departamento;
import com.mballen.curso.boot.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    void salvar(Funcionario funcionario);

    void editar(Funcionario funcionario);

    void excluir(Long id);

    Funcionario buscarPorId(Long id);

    List<Funcionario> buscarTodos();
}
