package com.example.productos.dto;

import ch.qos.logback.core.model.ComponentModel;
import com.example.productos.entitis.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring")
public interface ProductoMapper {
    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);
    ProductoDto productoToProductoDto (Producto producto);
    Producto productoDtoToProducto (ProductoDto productoDto);
    @Mapping(target = "id", ignore = true)
    Producto productoToSaveDto (ProductoToSaveDto productoToSaveDto);
}
