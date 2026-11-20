package com.aula.demo_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aula.demo_mvc.model.Usuario;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final List<Usuario> usuarios = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("usuarios", usuarios);
        return "usuarios/inicio";
    }

    @GetMapping("/usuario")
    public String exibirUsuario(Model model) {

        Usuario usuario = new Usuario();
        usuario.setNome("Carlos Alberto Segundo");
        usuario.setEmail("carlos.segundo@email.com");
        usuario.setTelefone("(43) 98765-4321");

        model.addAttribute("usuario", usuario);

        return "usuario";
    }

    @PostMapping
    public String cadastrarUsuario(@ModelAttribute Usuario usuario) {
        usuarios.add(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{indice}")
    public String editarUsuario(@PathVariable int indice, Model model) {
        if (indice >= 0 && indice < usuarios.size()) {
            model.addAttribute("usuario", usuarios.get(indice));
            model.addAttribute("indice", indice);
            return "usuario";
        }
        return "redirect:/usuarios";
    }

    @PostMapping("/editar/{indice}")
    public String atualizarUsuario(@PathVariable int indice, @ModelAttribute Usuario usuario) {
        if (indice >= 0 && indice < usuarios.size()) {
            usuarios.set(indice, usuario);
        }
        return "redirect:/usuarios";
    }

    @PostMapping("/excluir/{indice}")
    public String excluirUsuario(@PathVariable int indice) {
        if (indice >= 0 && indice < usuarios.size()) {
            usuarios.remove(indice);
        }
        return "redirect:/usuarios";
    }
}
