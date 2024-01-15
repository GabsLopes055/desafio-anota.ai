package com.gabriel.desafio.anota.ai.domain.products;

import com.gabriel.desafio.anota.ai.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    private String id;

    private String title;

    private String description;

    private String ownerId;

    private Integer price;

    private Category category;

    public Product(ProductDTO request) {
        this.title = request.title();
        this.description = request.description();
        this.ownerId = request.ownerId();
        this.price = request.price();
    }

}
