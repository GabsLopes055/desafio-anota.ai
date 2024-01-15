package com.gabriel.desafio.anota.ai.domain.products;

import com.gabriel.desafio.anota.ai.domain.category.Category;

public record ProductDTO(String title,String description, String ownerId, Integer price, String categoryId) {}
