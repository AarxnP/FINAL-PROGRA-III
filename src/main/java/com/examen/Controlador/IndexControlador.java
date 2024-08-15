package com.examen.Controlador;

import com.examen.Entidad.Cliente;
import com.examen.Exception.MiException;
import com.examen.Servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    // Mostrar el formulario (GET)
    @GetMapping("/registrar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Usuario/registro";  // Renderiza el formulario de registro
    }

    // Procesar el formulario (POST)
    @PostMapping("/inicioS")
    public String crearUsuario(@Validated Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Si hay errores de validación, volver a mostrar el formulario
            return "Usuario/registro.html";
        }

        try {
            clienteServicio.registrar(cliente.getNombre(), cliente.getEmail(), cliente.getPassword());
            model.addAttribute("exitoso", "Usuario registrado exitosamente");
            return "iniciosesion";
        } catch (MiException e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }
    }
}
