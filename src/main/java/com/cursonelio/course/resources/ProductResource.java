package com.cursonelio.course.resources;

import com.cursonelio.course.entities.Product;
import com.cursonelio.course.entities.User;
import com.cursonelio.course.services.ProductService;
import com.cursonelio.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Anotação que indica que essa classe é um controlador REST
@RequestMapping(value = "/products") // Define o caminho base para os endpoints deste controlador
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping // Anotação que indica que este método responde a requisições GET
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // Anotação que indica que este método responde a requisições GET com um ID específico
    public ResponseEntity<Product> findById(@PathVariable Long id){ // @PathVariable indica que o parâmetro id será extraído da URL
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
