package com.mballen.curso.boot.controller;

import com.mballen.curso.boot.model.Departamento;
import com.mballen.curso.boot.service.DepartamentoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping(path = "/cadastrar")
    public String cadastrar(Departamento departamento) {
        return "/departamento/cadastro";
    }

    @GetMapping(path = "/listar")
    public String listar(Model model) {
        List<Departamento> listaDepartamento = service.buscarTodos();
        model.addAttribute("departamentos", listaDepartamento);
        return "departamento/lista";
    }

    @PostMapping(path = "/salvar")
    public String salvar(Model model, Departamento departamento) {
        service.salvar(departamento);
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping(path = "/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, Model model) {
           Departamento departamentoId = service.buscarPorId(id);
           model.addAttribute("departamento", departamentoId);

        return "/departamento/cadastro";
    }

    @PostMapping(path = "/editar")
    public String editar(Departamento departamento) {
        service.salvar(departamento);
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping(path = "/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, Model model) {
        service.excluir(id);
        return this.listar(model);
    }
}
