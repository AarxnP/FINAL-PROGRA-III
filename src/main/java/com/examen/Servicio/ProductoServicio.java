package com.examen.Servicio;

import com.examen.Entidad.Producto;
import com.examen.Repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;

    public List<Producto> listarProductos(){
        return productoRepositorio.findAll();
    }
    public Optional<Producto> buscarProducto(Long id){
        return productoRepositorio.findById(id);
    }
    public  void  guadarProducto(Producto producto){
        productoRepositorio.save(producto);
    }
    public void eliminarProducto(Long id){
        productoRepositorio.deleteById(id);
    }
}