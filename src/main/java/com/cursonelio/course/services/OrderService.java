package com.cursonelio.course.services;

import com.cursonelio.course.entities.Order;
import com.cursonelio.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Anotação que indica que essa classe é um serviço do Spring
public class OrderService {
    // Aqui implementa a lógica de negócios relacionada aos pedidos
    // Por exemplo, métodos para buscar pedidos, criar novos pedidos, etc.

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id); // Busca um usuário pelo ID, retornando um Optional
        return obj.get(); // Retorna o usuário encontrado, ou lança uma exceção se não for encontrado
    }
}