package com.cursonelio.course.repositories;

import com.cursonelio.course.entities.OrderItem;
import com.cursonelio.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // JpaRepository já possui métodos prontos para operações CRUD
    // Não é necessário implementar nada aqui, o Spring Data JPA cuida disso
}
