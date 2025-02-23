package com.example.springbootcourse.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootcourse.models.ProductModel;

@Repository // Opcional, visto que extendemos o JPA que já é gerenciado por default.
// Nesse caso, ao usarmos a annotation e Repository deixamos claro que essa será uma classe gerenciada (Bean)
public interface ProductRepository extends JpaRepository<ProductModel, UUID>{
    
}
