package com.example.productos.dto;

public record ProductoDto(
        Long id,
        String name,
        String description,
        Double price,
        Integer stock
) {
}
