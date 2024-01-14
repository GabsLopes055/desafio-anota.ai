package com.gabriel.desafio.anota.ai.service;

import com.gabriel.desafio.anota.ai.domain.category.Category;
import com.gabriel.desafio.anota.ai.domain.category.CategoryDTO;
import com.gabriel.desafio.anota.ai.domain.repositories.CategoryRepository;
import com.gabriel.desafio.anota.ai.service.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    /*Salvando uma categoria*/
    public Category createNewCategory(CategoryDTO request) {
        Category newCategory = new Category(request);
        return this.repository.save(newCategory);
    }

    /*Listando todas categorias*/
    public List<Category> listAllCategories() {
        return this.repository.findAll();
    }

    /*editando categoria*/
    public Category updateCategory(String id, CategoryDTO request) {

        Category findCategory = this.repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if(!request.title().isEmpty()) findCategory.setTitle(request.title());
        if(!request.description().isEmpty()) findCategory.setDescription(request.description());

        this.repository.save(findCategory);

        return findCategory;
    }

    /*deletando uma categoria*/
    public void deleteCategory(String id) {

        Category findCategory = this.repository.findById(id).orElseThrow(EntityNotFoundException::new);

        this.repository.delete(findCategory);

    }


}
