package com.example.productos.service;

import com.example.productos.dto.ProdcutoMapper;
import com.example.productos.dto.ProductoDto;
import com.example.productos.dto.ProductoToSaveDto;
import com.example.productos.entitis.Producto;
import com.example.productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImp implements ProductoService{
    private final ProductoRepository productoRepository;
    private final ProdcutoMapper prodcutoMapper;

    public ProductoServiceImp(ProductoRepository productoRepository, ProdcutoMapper prodcutoMapper) {
        this.productoRepository = productoRepository;
        this.prodcutoMapper = prodcutoMapper;
    }

    @Override
    public ProductoDto guardaProducto(ProductoToSaveDto productoToSaveDto) {
        return null;
    }

    @Override
    public ProductoDto getProductoById(Long id) {
        return null;
    }

    @Override
    public void borrarProducto(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow();
        productoRepository.delete(producto);
    }

    @Override
    public ProductoDto actualizarProdcuto(Long id, ProductoDto productoDto) {
        return null;
    }
}
