package com.cursonelio.course.repositories;

import com.cursonelio.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository já possui métodos prontos para operações CRUD
    // Não é necessário implementar nada aqui, o Spring Data JPA cuida disso
}
