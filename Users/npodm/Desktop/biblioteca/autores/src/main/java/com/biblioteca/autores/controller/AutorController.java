
package com.biblioteca.autores.controller;

import com.biblioteca.autores.model.Autor;
import com.biblioteca.autores.service.IAutoresService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {
    
    @Autowired
    private IAutoresService autorServ;
    
    //  Creación: localhost:8080/autors/crear
    @PostMapping("/crear")
    public String saveAutor(@RequestBody Autor autor) {
        autorServ.saveAutor(autor);
        return "El autor fue creado correctamente";
    }

//  Lista completa de autors: localhost:8080/autors
    @GetMapping("/traerLista")
    public List<Autor> getAutores() {
        return autorServ.getAutores();
    }

//  Traer un autor  en particular: localhost:8080/autors/{id}
    @GetMapping("/traerId/{id}")
    public Autor getAutor(@PathVariable Long id) {
        return autorServ.findAutor(id);
    }
    
    
}
