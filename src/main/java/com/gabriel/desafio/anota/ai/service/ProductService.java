package com.gabriel.desafio.anota.ai.service;

import com.gabriel.desafio.anota.ai.domain.category.Category;
import com.gabriel.desafio.anota.ai.domain.products.Product;
import com.gabriel.desafio.anota.ai.domain.products.ProductDTO;
import com.gabriel.desafio.anota.ai.domain.repositories.ProductRepository;
import com.gabriel.desafio.anota.ai.service.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final CategoryService categoryService;

    ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.repository = productRepository;
        this.categoryService = categoryService;
    }

    /*metodo para salvar um novo produto*/
    public Product createProduct(ProductDTO productDTO) {

        Category findCategory = this.categoryService.findCategoriesById(productDTO.categoryId()).orElseThrow(EntityNotFoundException::new);

        Product productSave = new Product(productDTO);
        productSave.setCategory(findCategory);
        return repository.save(productSave);
    }


    /*Metodo para listar todos os produtos*/
    public List<Product> listAllProducts() {

        return this.repository.findAll();

    }


    /*Metodo para editar um produto*/
    public Product editProduct(String idEdit, ProductDTO request) {

        Product editProduct = this.repository.findById(idEdit).orElseThrow(EntityNotFoundException::new);

        if (request.categoryId() != null) {
            this.categoryService.findCategoriesById(request.categoryId()).ifPresent(editProduct::setCategory);
        }

        if (!request.title().isEmpty()) editProduct.setTitle(request.title());
        if (!request.description().isEmpty()) editProduct.setDescription(request.description());
        if (!request.ownerId().isEmpty()) editProduct.setOwnerId(request.ownerId());
        if (request.price() != null) editProduct.setPrice(request.price());

        return this.repository.save(editProduct);

    }

    /*Metodo para excluir um produto*/
    public void deleteProduct(String id) {

        Product deleteProduct = this.repository.findById(id).orElseThrow(EntityNotFoundException::new);

        this.repository.delete(deleteProduct);

    }
}
