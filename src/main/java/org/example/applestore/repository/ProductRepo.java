package org.example.applestore.repository;

import org.example.applestore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product , Long> {

    boolean existsByEmailAndPassword(String email , String password);

    long countById(Long id);

    Long id(Long id);
}
