package com.aula.demo_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aula.demo_mvc.model.Categoria;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @GetMapping
    public String inicio() {
        return "categorias/inicio";
    }

    @GetMapping("/categoria")
    public String exibirCategoria(Model model) {

        Categoria categoria = new Categoria();
        categoria.setNome("Romance");
        categoria.setDescricao("Obras de ficção em prosa");
        categoria.setCodigo("ROM-001");

        model.addAttribute("categoria", categoria);

        return "categoria";
    }

}
