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
public class registroControlador {
    @GetMapping("/registro")
    public String Registro(Model model){
        model.addAttribute("usuario",new Cliente());
        return "Usuario/registro.html";
    }
    @PostMapping("/registrarCliente")
    public String registrarCliente(@Validated @ModelAttribute Cliente cliente, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "Usuario/registro.html";
        }else {
            return "Usuario/iniciosesion.html";
        }
    }
}