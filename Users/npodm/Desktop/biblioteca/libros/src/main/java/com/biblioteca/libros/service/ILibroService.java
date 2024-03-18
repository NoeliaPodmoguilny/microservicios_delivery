package com.biblioteca.libros.service;



import com.biblioteca.libros.model.Libro;
import java.util.List;

public interface ILibroService {

    public List<Libro> getLibros();

    public Libro findLibro(Long id);

    public List<String> saveLibro(Libro newLibro);

}
