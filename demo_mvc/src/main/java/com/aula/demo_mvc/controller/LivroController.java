package com.aula.demo_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aula.demo_mvc.model.Livro;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final List<Livro> livros = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("livros", livros);
        return "livros/inicio";
    }

    @GetMapping("/livro")
    public String exibirLivro(Model model) {

        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-00-00000-0");

        model.addAttribute("livro", livro);

        return "livro";
    }

    @PostMapping
    public String cadastrarLivro(@ModelAttribute Livro livro) {
        livros.add(livro);
        return "redirect:/livros";
    }

    @GetMapping("/editar/{indice}")
    public String editarLivro(@PathVariable int indice, Model model) {
        if (indice >= 0 && indice < livros.size()) {
            model.addAttribute("livro", livros.get(indice));
            model.addAttribute("indice", indice);
            return "livro";
        }
        return "redirect:/livros";
    }

    @PostMapping("/editar/{indice}")
    public String atualizarLivro(@PathVariable int indice, @ModelAttribute Livro livro) {
        if (indice >= 0 && indice < livros.size()) {
            livros.set(indice, livro);
        }
        return "redirect:/livros";
    }

    @PostMapping("/excluir/{indice}")
    public String excluirLivro(@PathVariable int indice) {
        if (indice >= 0 && indice < livros.size()) {
            livros.remove(indice);
        }
        return "redirect:/livros";
    }
}
