package com.examen.Entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;

}

