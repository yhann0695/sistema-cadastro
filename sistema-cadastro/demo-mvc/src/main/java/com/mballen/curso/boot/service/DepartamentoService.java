package com.mballen.curso.boot.service;

import com.mballen.curso.boot.model.Departamento;
import com.mballen.curso.boot.repository.IDepartamentoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public void excluir(Long id) {
        if(!this.departamentoTemCargos(id)) {
            repository.deleteById(id);
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
