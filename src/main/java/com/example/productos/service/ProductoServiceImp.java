package com.example.productos.service;

import com.example.productos.dto.ProductoDto;
import com.example.productos.dto.ProductoMapper;
import com.example.productos.dto.ProductoToSaveDto;
import com.example.productos.entitis.Producto;
import com.example.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoMapper productoMapper;

    @Override
    @Transactional
    public ProductoDto guardaProducto(ProductoToSaveDto productoToSaveDto) {
        Producto producto = productoMapper.productoToSaveDto(productoToSaveDto);
        Producto savedProducto = productoRepository.save(producto);
        return productoMapper.productoToProductoDto(savedProducto);
    }

    @Override
    @Transactional
    public ProductoDto actualizarProdcuto(Long id, ProductoDto productoDto) {
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Producto no encontrado"));
        productoExistente.setName(productoDto.name());
        productoExistente.setDescription(productoDto.description());
        productoExistente.setPrice(productoDto.price());
        productoExistente.setStock(productoDto.stock());

        Producto putProducto = productoRepository.save(productoExistente);
        return productoMapper.productoToProductoDto(putProducto);
    }

    @Override
    @Transactional
    public void borrarProducto(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Producto no encontrado"));
        productoRepository.delete(producto);
    }

    @Override
    public ProductoDto getProductoById(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Producto no encontrado"));
        return productoMapper.productoToProductoDto(producto);
    }
}
