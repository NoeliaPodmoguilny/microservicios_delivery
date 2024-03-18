package com.biblioteca.libros.service;

import com.biblioteca.libros.model.Autor;
import com.biblioteca.libros.model.Libro;
import com.biblioteca.libros.repository.IAutoresAPIClient;
import com.biblioteca.libros.repository.ILibroRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService implements ILibroService {

    @Autowired
    private IAutoresAPIClient apiAutor;

    @Autowired
    private ILibroRepository libroRepo;

    @Override
    public List<String> saveLibro(Libro newLibro) {
        
        System.out.println("INICIO METODO SAVELIBRO");
        //obtengo la lista de autores completa desde la api 
        List<Autor> listaAutores = apiAutor.getAutores();
        System.out.println("lista de autores API: " + listaAutores);
        
        //creo el nuevo libro 
        libroRepo.save(newLibro);
        System.out.println("nuevo libro: " + newLibro);
        System.out.println("NUEVO LIBRO CREADO: " + newLibro.getIsbn());
        
        //creo una nueva lista para agregar los datos de nacionalidad y nombre de autor
        List<String> autorPorLibro = new ArrayList<>();
        
        //recorro la lista de autores para añadir los datos a la nueva lista
        if (listaAutores != null && !listaAutores.isEmpty()) {
            for (Autor a : listaAutores) {
                if (a.getIdLibros() != null && !a.getIdLibros().isEmpty()){
                    if (a.getIdLibros().contains(newLibro.getIsbn())) {
                        autorPorLibro.add("Nombre de autor: " + a.getNombre_completo() + ", nacionalidad: " + a.getNacionalidad());
                        System.out.println("autor por libro: " + a);
                    }
                }else{
                    System.out.println("No se encontró el autor");
                }
            }
        }
        //devuelvo lista de autores segun id del libro
        return autorPorLibro;

    }

    @Override
    public List<Libro> getLibros() {
        return libroRepo.findAll();
    }

    @Override
    public Libro findLibro(Long id) {
        return libroRepo.findById(id).orElse(null);
    }
}
