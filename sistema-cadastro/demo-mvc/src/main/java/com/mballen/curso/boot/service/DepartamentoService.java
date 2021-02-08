package com.mballen.curso.boot.service;

import com.mballen.curso.boot.model.Departamento;
import com.mballen.curso.boot.repository.IDepartamentoRepository;
import com.mballen.curso.boot.util.Mensagens;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private IDepartamentoRepository repository;

    public void salvar(Departamento departamento) {
        repository.save(departamento);
    }

    public List<Departamento> buscarTodos() {
        return repository.findAll();
    }

    public Departamento buscarPorId(Long id) {
        return repository.getOne(id);
    }

    public void excluir(Long id, Model model) {
        if(this.departamentoTemCargos(id)) {
            model.addAttribute("fail", Mensagens.MSG_ERRO_DEPARTAMENTO_EXCLUSAO);
        } else {
            repository.deleteById(id);
            model.addAttribute("success", Mensagens.MSG_SUCCESSO_EXCLUSAO);
        }
    }

    private boolean departamentoTemCargos(Long id) {
        boolean isPresent = true;
        if(this.buscarPorId(id).getCargos().isEmpty()) {
            isPresent = false;
        }
        return isPresent;
    }


}
