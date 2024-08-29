package com.example.productos.dto;

public record ProductoToSaveDto (
        Long id,
        String name,
        String description,
        Double price,
        Integer stock
){
}
