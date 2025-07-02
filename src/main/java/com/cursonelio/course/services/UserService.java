package com.cursonelio.course.services;

import java.util.List;
import java.util.Optional;

import com.cursonelio.course.entities.User;
import com.cursonelio.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Anotação que indica que essa classe é um serviço do Spring
public class UserService {
    // Aqui você pode implementar a lógica de negócios relacionada aos usuários
    // Por exemplo, métodos para buscar usuários, criar novos usuários, etc.
    // Você pode injetar o UserRepository aqui para acessar o banco de dados
    // e realizar operações CRUD nos usuários.

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id); // Busca um usuário pelo ID, retornando um Optional
        return obj.get(); // Retorna o usuário encontrado, ou lança uma exceção se não for encontrado
    }
}