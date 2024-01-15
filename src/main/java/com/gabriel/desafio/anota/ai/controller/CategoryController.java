package com.gabriel.desafio.anota.ai.controller;

import com.gabriel.desafio.anota.ai.domain.category.Category;
import com.gabriel.desafio.anota.ai.domain.category.CategoryDTO;
import com.gabriel.desafio.anota.ai.service.CategoryService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService service;

    CategoryController(CategoryService service) {
        this.service = service;
    }

    /*Metodo para salvar uma categoria*/
    @PostMapping
    public ResponseEntity<Category> createdCategory(@RequestBody CategoryDTO request) {
        return ResponseEntity.ok().body(this.service.createNewCategory(request));
    }

    /*Metodo para listar todas categorias*/
    @GetMapping
    public ResponseEntity<List<Category>> listAll() {
        return ResponseEntity.ok().body(this.service.listAllCategories());
    }

    /*Metodo para editar uma categoria*/
    @PutMapping("/{idEdit}")
    public ResponseEntity<Category> editCategory(@PathVariable(value = "idEdit") String id, @RequestBody CategoryDTO request) {
        return ResponseEntity.ok().body(this.service.updateCategory(id,request));
    }

    /*Metodo para excluir uma categoria*/
    @DeleteMapping("/{idDelete}")
    public ResponseEntity deleteCategory(@PathVariable(value = "idDelete") String id) {
        this.service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
