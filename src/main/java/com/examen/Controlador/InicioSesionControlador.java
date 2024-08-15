package com.examen.Controlador;

import com.examen.Entidad.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InicioSesionControlador {

    @GetMapping("/inicioS")
    public String inicioS(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Usuario/iniciosesion"; // Asegúrate de que el nombre del archivo HTML sea correcto
    }

    @PostMapping("/inicioSUsuario")
    public String inicioSUsuario(@Validated @ModelAttribute("cliente") Cliente cliente, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "Usuario/iniciosesion"; // Regresa a la página de inicio de sesión si hay errores
        }
        // Aquí podrías agregar lógica para autenticar al usuario
        return "index"; // Redirige a la página de registro exitoso si no hay errores
    }
}

