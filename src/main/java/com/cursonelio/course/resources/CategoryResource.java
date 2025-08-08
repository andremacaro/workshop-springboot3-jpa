package com.cursonelio.course.resources;

import com.cursonelio.course.entities.Category;
import com.cursonelio.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Anotação que indica que essa classe é um controlador REST
@RequestMapping(value = "/categories") // Define o caminho base para os endpoints deste controlador
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping // Anotação que indica que este método responde a requisições GET
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // Anotação que indica que este método responde a requisições GET com um ID específico
    public ResponseEntity<Category> findById(@PathVariable Long id){ // @PathVariable indica que o parâmetro id será extraído da URL
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
