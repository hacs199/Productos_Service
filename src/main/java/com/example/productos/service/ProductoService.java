package com.example.productos.service;

import com.example.productos.dto.ProductoDto;
import com.example.productos.dto.ProductoToSaveDto;

public interface ProductoService {
    ProductoDto guardaProducto (ProductoToSaveDto productoToSaveDto);
    ProductoDto getProductoById(Long id);
    void borrarProducto(Long id);
    ProductoDto actualizarProdcuto(Long id, ProductoDto productoDto);
}
