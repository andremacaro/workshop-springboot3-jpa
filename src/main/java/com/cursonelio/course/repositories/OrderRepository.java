package com.cursonelio.course.repositories;

import com.cursonelio.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // JpaRepository já possui métodos prontos para operações CRUD
    // Não é necessário implementar nada aqui, o Spring Data JPA cuida disso
}
