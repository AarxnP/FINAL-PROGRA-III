package com.examen.Controlador;

import com.examen.Entidad.Usuario;
import com.examen.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
@Controller
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    //LEER
    @GetMapping("/usuario")
    public String mostrarUsuario(Model model){
        List<Usuario> clientes = usuarioServicio.listarUsuario();
        model.addAttribute("usuario", clientes);
        return "/Cliente/listarCliente";
    }

    //CREAR
    @GetMapping("/formularioUsuario")
    public String formularioUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "/Cliente/formularioCliente";
    }

    @PostMapping("/guardarUsuario")
    public String crearUsuario(Usuario usuario){
        usuarioServicio.guadarUsuario(usuario);
        return "redirect:/usuario";
    }

    //ACTUALIZAR
    @GetMapping("/editarUsuario/{id}")
    public String actualizarUsuario(@PathVariable Long id, Model model){
        Optional<Usuario> cliente = usuarioServicio.buscarUsuario(id);
        model.addAttribute("usuario", cliente);
        return "/Cliente/formularioCliente";
    }

    //ELIMINAR
    @GetMapping("/eliminarUsuario/{id}")
    public String borrarUsuario(@PathVariable Long id){
        usuarioServicio.eliminarUsuario(id);
        return "redirect:/usuario";
    }
}
