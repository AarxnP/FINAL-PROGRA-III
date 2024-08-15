package com.examen.Servicio;

import com.examen.Entidad.Usuario;
import com.examen.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

//    public List<Producto> buscarProductosByClienteId(Long id_cliente){
//        return clienteRepositorio.findById(id_cliente)
//                .map(Cliente::mostrarProductos)
//                .orElse(List.of());
//    }

    public List<Usuario> listarUsuario(){
        return usuarioRepositorio.findAll();
    }
    public Optional<Usuario> buscarUsuario(Long id){
        return usuarioRepositorio.findById(id);
    }
    public  void  guadarUsuario(Usuario cliente){
        usuarioRepositorio.save(cliente);
    }
    public void eliminarUsuario(Long id){
        usuarioRepositorio.deleteById(id);
    }
}
