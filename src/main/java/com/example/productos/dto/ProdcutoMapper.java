package com.example.productos.dto;

import com.example.productos.entitis.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring")
public interface ProdcutoMapper {
    ProdcutoMapper INSTANCE = Mappers.getMapper(ProdcutoMapper.class);
    ProductoDto productoToProductoDto (Producto producto);
    Producto productoDtoToProdcuto (ProductoDto productoDto);
    @Mapping(target = "id", ignore = true)
    Producto productoToSaveDto (ProductoToSaveDto productoToSaveDto);
}
