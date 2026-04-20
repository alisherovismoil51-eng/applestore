package org.example.applestore.repository;

import org.example.applestore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category , Long> {

    boolean existsByEmailAndPassword(String email , String password);

    long countById(Long id);

    Long id(Long id);
}
