package com.gabriel.desafio.anota.ai.domain.repositories;
import com.gabriel.desafio.anota.ai.domain.products.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
