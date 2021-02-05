package com.mballen.curso.boot.service;

import com.mballen.curso.boot.model.Cargo;
import com.mballen.curso.boot.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService{

    @Autowired
    private CargoRepository repository;

    @Override
    public void salvar(Cargo cargo) {
        repository.save(cargo);
    }

    @Override
    public void editar(Cargo cargo) {
        repository.update(cargo);
    }

    @Override
    public void excluir(Long id) {
        repository.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {
        return repository.findAll();
    }
}
