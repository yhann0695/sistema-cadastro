package com.mballen.curso.boot.controller;

import com.mballen.curso.boot.model.Cargo;
import com.mballen.curso.boot.model.Departamento;
import com.mballen.curso.boot.service.CargoService;
import com.mballen.curso.boot.service.DepartamentoService;
import com.mballen.curso.boot.util.Mensagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(path = "/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Cargo cargo) {
        return "/cargo/cadastro";
    }

    @GetMapping(path = "/listar")
    public String listar(Model model) {
        List<Cargo> listaCargos = cargoService.buscarTodos();
        model.addAttribute("cargos", listaCargos);
        return "/cargo/lista";
    }

    @PostMapping(path = "/salvar")
    public String salvar(Cargo cargo, RedirectAttributes attr) {
        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", Mensagens.MSG_INSERIR_SUCESSO);
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping(path = "/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, Model model) {
        Cargo cargoId = cargoService.buscarPorId(id);
        model.addAttribute("cargo", cargoId);
        return "/cargo/cadastro";
    }

    @PostMapping(path = "/editar")
    public String editar(Cargo cargo, RedirectAttributes attr) {
        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", Mensagens.MSG_EDICAO_SUCESSO);
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping(path = "/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        cargoService.excluir(id, attr);
        return "redirect:/cargos/listar";
    }

    @ModelAttribute("departamentos")
    public List<Departamento> listaDeDepartamentos() {
        return departamentoService.buscarTodos();
    }
}
