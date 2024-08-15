package com.examen.Repositorio;

import com.examen.Entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String> {

    @Query("SELECT u from Cliente u WHERE u.email=:email")
    public Cliente buscarClienteByEmail(@Param("email") String email);
}
