package com.mballen.curso.boot.controller;

import com.mballen.curso.boot.model.Cargo;
import com.mballen.curso.boot.model.Funcionario;
import com.mballen.curso.boot.model.UF;
import com.mballen.curso.boot.service.CargoService;
import com.mballen.curso.boot.service.FuncionarioService;
import com.mballen.curso.boot.util.Mensagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(path = "funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CargoService cargoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario funcionario) {
        return "/funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Funcionario> listaFuncionarios = funcionarioService.buscarTodos();
        model.addAttribute("funcionarios", listaFuncionarios);
        return "/funcionario/lista";
    }

    @PostMapping(path = "/salvar")
    public String salvar(Funcionario funcionario, RedirectAttributes attr) {
        funcionarioService.salvar(funcionario);
        attr.addFlashAttribute("success", Mensagens.MSG_INSERIR_SUCESSO);
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping(path = "/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, Model model) {
        Funcionario funcionarioId = funcionarioService.buscarPorId(id);
        model.addAttribute("funcionario", funcionarioId);
        return "/funcionario/cadastro";
    }

    @PostMapping(path = "/editar")
    public String editar(Funcionario funcionario, RedirectAttributes attr) {
        funcionarioService.salvar(funcionario);
        attr.addFlashAttribute("success", Mensagens.MSG_EDICAO_SUCESSO);
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping(path = "/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        funcionarioService.excluir(id);
        attr.addFlashAttribute("success", Mensagens.MSG_SUCCESSO_EXCLUSAO);
        return "redirect:/funcionarios/listar";
    }

    @GetMapping(path = "/buscar/nome")
    public String buscarPorNome(@RequestParam("nome") String nome, Model model) {
        List<Funcionario> funcionarios = funcionarioService.buscarPorNome(nome);
        model.addAttribute("funcionarios", funcionarios);
        return "/funcionario/lista";
    }

    @GetMapping(path = "/buscar/cargo")
    public String buscarPorCargo(@RequestParam("id") Long id, Model model) {
        List<Funcionario> cargosFuncionarios = funcionarioService.buscarPorCargo(id);
        model.addAttribute("funcionarios", cargosFuncionarios);
        return "/funcionario/lista";
    }

    @GetMapping(path = "/buscar/data")
    public String buscarPorDatas(@RequestParam(value = "entrada", required = false)
                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate entrada,
                                 @RequestParam(value = "saida", required = false)
                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida, Model model) {

        List<Funcionario> funcionarioList = funcionarioService.buscarPorDatas(entrada, saida);
        model.addAttribute("funcionarios", funcionarioList);
        return "/funcionario/lista";
    }

    @ModelAttribute("cargos")
    public List<Cargo> buscarCargos() {
        return cargoService.buscarTodos();
    }

    @ModelAttribute("ufs")
    public UF[] getUFs() {
        return UF.values();
    }
}
