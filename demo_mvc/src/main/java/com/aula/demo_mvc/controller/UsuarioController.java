package com.aula.demo_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aula.demo_mvc.model.Usuario;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping
    public String inicio() {
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

}
