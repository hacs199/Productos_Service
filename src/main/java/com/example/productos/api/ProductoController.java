package com.example.productos.api;

import com.example.productos.dto.ProductoDto;
import com.example.productos.dto.ProductoToSaveDto;
import com.example.productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/guardar")
    public ResponseEntity<ProductoDto> guardaProducto (@RequestBody ProductoToSaveDto productoToSaveDto){
        ProductoDto productoDto = productoService.guardaProducto(productoToSaveDto);
        return new ResponseEntity<>(productoDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getProductoById (@PathVariable Long id) {
        ProductoDto productoDto = productoService.getProductoById(id);
        return new ResponseEntity<>(productoDto, HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> borrarProducto(@PathVariable Long id) {
        productoService.borrarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> actualizarProducto(@PathVariable Long id, ProductoDto productoDto){
        ProductoDto putProductoDto = productoService.actualizarProdcuto(id, productoDto);
        return new ResponseEntity<>(putProductoDto, HttpStatus.OK);
    }
}
