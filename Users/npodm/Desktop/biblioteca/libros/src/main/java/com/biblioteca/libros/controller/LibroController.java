package com.biblioteca.libros.controller;


import com.biblioteca.libros.model.Libro;
import com.biblioteca.libros.service.ILibroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private ILibroService libroServ;

    //  Creación: localhost:8080/libros/crear
    @PostMapping("/crear")
    public List<String> saveLibro(@RequestBody Libro newLibro) {
        return libroServ.saveLibro(newLibro);

    }

    //  Lista completa de libros: localhost:8080/libros
    @GetMapping("/traerLista")
    public List<Libro> getLibros() {
        return libroServ.getLibros();
    }

//  Traer un libro  en particular: localhost:8080/libros/{id}
    @GetMapping("/traerLibro/{id}")
    public Libro getLibro(@PathVariable Long id) {
        return libroServ.findLibro(id);
    }

}
