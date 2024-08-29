package com.example.productos.repository;

import com.example.productos.entitis.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository <Producto, Long> {

}
