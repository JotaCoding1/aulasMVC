package com.aula.demo_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aula.demo_mvc.model.Categoria;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final List<Categoria> categorias = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("categorias", categorias);
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

    @PostMapping
    public String cadastrarCategoria(@ModelAttribute Categoria categoria) {
        categorias.add(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{indice}")
    public String editarCategoria(@PathVariable int indice, Model model) {
        if (indice >= 0 && indice < categorias.size()) {
            model.addAttribute("categoria", categorias.get(indice));
            model.addAttribute("indice", indice);
            return "categoria";
        }
        return "redirect:/categorias";
    }

    @PostMapping("/editar/{indice}")
    public String atualizarCategoria(@PathVariable int indice, @ModelAttribute Categoria categoria) {
        if (indice >= 0 && indice < categorias.size()) {
            categorias.set(indice, categoria);
        }
        return "redirect:/categorias";
    }

    @PostMapping("/excluir/{indice}")
    public String excluirCategoria(@PathVariable int indice) {
        if (indice >= 0 && indice < categorias.size()) {
            categorias.remove(indice);
        }
        return "redirect:/categorias";
    }
}
