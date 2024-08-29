package com.example.productos.repository;

import com.example.productos.AbstractIntegrationDBTest;
import com.example.productos.entitis.Producto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductoRepositoryTest extends AbstractIntegrationDBTest {

    @Autowired
    private ProductoRepository productoRepository;


    /*@Test
    public void buscarProductoPorNombre(){
        Producto producto = Producto.builder()
                .name("Papa")
                .description("Papa de tierra")
                .price(100.0)
                .stock(1)
                .build();
        Producto productoSaved = productoRepository.save(producto);

        assertThat(productoSaved.getId()).isNotNull();
    }*/

    @Test
    void buscarClientePorCorreo() {
        //Given
        Producto producto = Producto.builder()
                .name("and@gmsil.com")
                .description("calle4")
                .price(10.0)
                .build();
        productoRepository.save(producto);
        //When
        List<Producto> productoSeach = productoRepository.findByName("and@gmsil.com");
        //Then
        assertThat(productoSeach).isNotEmpty();
        assertThat(productoSeach.get(0).getName()).isEqualTo("and@gmail.com");
    }

    @BeforeEach
    void setUp(){
        productoRepository.deleteAll();
    }

}