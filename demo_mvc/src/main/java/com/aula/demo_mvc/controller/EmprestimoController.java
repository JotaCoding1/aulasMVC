package com.aula.demo_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aula.demo_mvc.model.Emprestimo;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @GetMapping
    public String inicio() {
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

}
