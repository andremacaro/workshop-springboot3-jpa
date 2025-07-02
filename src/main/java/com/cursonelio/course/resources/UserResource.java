package com.cursonelio.course.resources;

import com.cursonelio.course.entities.User;
import com.cursonelio.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Anotação que indica que essa classe é um controlador REST
@RequestMapping(value = "/users") // Define o caminho base para os endpoints deste controlador
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping // Anotação que indica que este método responde a requisições GET
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // Anotação que indica que este método responde a requisições GET com um ID específico
    public ResponseEntity<User> findById(@PathVariable Long id){ // @PathVariable indica que o parâmetro id será extraído da URL
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
