package com.aula.demo_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aula.demo_mvc.model.Autor;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private final List<Autor> autores = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("autores", autores);
        return "autores/inicio";
    }

    @GetMapping("/autor")
    public String exibirAutor(Model model) {

        Autor autor = new Autor();
        autor.setNome("Machado de Assis");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento("21/06/1839");

        model.addAttribute("autor", autor);

        return "autor";
    }

    @PostMapping
    public String cadastrarAutor(@ModelAttribute Autor autor) {
        autores.add(autor);
        return "redirect:/autores";
    }

    @GetMapping("/editar/{indice}")
    public String editarAutor(@PathVariable int indice, Model model) {
        if (indice >= 0 && indice < autores.size()) {
            model.addAttribute("autor", autores.get(indice));
            model.addAttribute("indice", indice);
            return "autor";
        }
        return "redirect:/autores";
    }

    @PostMapping("/editar/{indice}")
    public String atualizarAutor(@PathVariable int indice, @ModelAttribute Autor autor) {
        if (indice >= 0 && indice < autores.size()) {
            autores.set(indice, autor);
        }
        return "redirect:/autores";
    }

    @PostMapping("/excluir/{indice}")
    public String excluirAutor(@PathVariable int indice) {
        if (indice >= 0 && indice < autores.size()) {
            autores.remove(indice);
        }
        return "redirect:/autores";
    }
}
