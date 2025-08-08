package com.cursonelio.course.repositories;

import com.cursonelio.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository já possui métodos prontos para operações CRUD
    // Não é necessário implementar nada aqui, o Spring Data JPA cuida disso
}
