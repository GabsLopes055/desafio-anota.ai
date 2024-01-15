package com.gabriel.desafio.anota.ai.controller;

import com.gabriel.desafio.anota.ai.domain.products.Product;
import com.gabriel.desafio.anota.ai.domain.products.ProductDTO;
import com.gabriel.desafio.anota.ai.service.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService service;

    ProductController(ProductService service) {
        this.service = service;
    }

    /*Metodo para salvar um produto*/
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createProduct(request));
    }

    /*Metodo para buscar todos os produtos*/
    @GetMapping
    public ResponseEntity<List<Product>> listAllProducts() {
        return ResponseEntity.ok().body(this.service.listAllProducts());
    }

    /*Metodo para editar um produto*/
    @PutMapping("/{idEdit}")
    public ResponseEntity<Product> editProduct(@PathVariable("idEdit") String idEdit, @RequestBody ProductDTO request) {
        return ResponseEntity.ok().body(this.service.editProduct(idEdit, request));
    }

    @DeleteMapping("/{idDelete}")
    public ResponseEntity deleteProdut(@PathVariable("idDelete") String id) {
        this.service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


}
