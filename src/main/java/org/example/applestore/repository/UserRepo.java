package org.example.applestore.repository;

import org.example.applestore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User , Long> {

    boolean existsByEmailAndPassword(String email , String password);

    long countById(Long id);


}
