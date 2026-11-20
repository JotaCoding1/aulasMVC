package com.aula.demo_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aula.demo_mvc.model.Emprestimo;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final List<Emprestimo> emprestimos = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("emprestimos", emprestimos);
        return "emprestimos/inicio";
    }

    @GetMapping("/emprestimo")
    public String exibirEmprestimo(Model model) {

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo("01/11/2026");
        emprestimo.setDataDevolucao("15/11/2026");
        emprestimo.setStatus("Em andamento");

        model.addAttribute("emprestimo", emprestimo);

        return "emprestimo";
    }

    @PostMapping
    public String cadastrarEmprestimo(@ModelAttribute Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
        return "redirect:/emprestimos";
    }

    @GetMapping("/editar/{indice}")
    public String editarEmprestimo(@PathVariable int indice, Model model) {
        if (indice >= 0 && indice < emprestimos.size()) {
            model.addAttribute("emprestimo", emprestimos.get(indice));
            model.addAttribute("indice", indice);
            return "emprestimo";
        }
        return "redirect:/emprestimos";
    }

    @PostMapping("/editar/{indice}")
    public String atualizarEmprestimo(@PathVariable int indice, @ModelAttribute Emprestimo emprestimo) {
        if (indice >= 0 && indice < emprestimos.size()) {
            emprestimos.set(indice, emprestimo);
        }
        return "redirect:/emprestimos";
    }

    @PostMapping("/excluir/{indice}")
    public String excluirEmprestimo(@PathVariable int indice) {
        if (indice >= 0 && indice < emprestimos.size()) {
            emprestimos.remove(indice);
        }
        return "redirect:/emprestimos";
    }
}
