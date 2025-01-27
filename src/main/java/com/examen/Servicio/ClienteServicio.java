package com.examen.Servicio;

import com.examen.Entidad.Cliente;
import com.examen.Exception.MiException;
import com.examen.Repositorio.ClienteRepositorio;
import com.examen.Rol.Rol;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServicio implements UserDetailsService {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Transactional
    public void registrar(String nombre, String email, String password) throws MiException {
        Cliente usuario = new Cliente();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.USER);
        clienteRepositorio.save(usuario);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente usuario = clienteRepositorio.buscarClienteByEmail(email);
        if(usuario !=null){
            List<GrantedAuthority> permisos = new ArrayList<>();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_"+usuario.getRol().toString());
            permisos.add(p);
            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
        }
        else {
            throw new UsernameNotFoundException("Usuario no encontrado con email: " + email);
        }
    }
}
