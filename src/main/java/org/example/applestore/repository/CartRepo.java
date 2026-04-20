package org.example.applestore.repository;

import org.example.applestore.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart , Long> {

    boolean existsByEmailAndid(String email , String password);

    long countById(Long id);

    Long id(Long id);
}
