package com.mballen.curso.boot.service;

import com.mballen.curso.boot.model.Cargo;
import com.mballen.curso.boot.repository.ICargoRepository;
import com.mballen.curso.boot.util.Mensagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private ICargoRepository repository;

    public void salvar(Cargo cargo) {
        repository.save(cargo);
    }

    public List<Cargo> buscarTodos() {
        return repository.findAll();
    }

    public Cargo buscarPorId(Long id) {
        return repository.getOne(id);

    }

    public void excluir(Long id, RedirectAttributes attr) {
        if(cargoTemFuncionarios(id)) {
            attr.addFlashAttribute("fail", Mensagens.MSG_ERRO_CARGO_EXCLUSAO);
        } else {
            repository.deleteById(id);
            attr.addFlashAttribute("success", Mensagens.MSG_SUCCESSO_EXCLUSAO);
        }
    }

    private boolean cargoTemFuncionarios(Long id) {
        boolean isPresent = true;
        if(this.buscarPorId(id).getFuncionarios().isEmpty()) {
            isPresent = false;
        }
        return isPresent;
    }
}
