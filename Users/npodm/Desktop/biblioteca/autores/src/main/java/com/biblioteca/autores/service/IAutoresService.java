
package com.biblioteca.autores.service;

import com.biblioteca.autores.model.Autor;
import java.util.List;


public interface IAutoresService {

    public void saveAutor(Autor autor);

    public List<Autor> getAutores();

    public Autor findAutor(Long id);
    
    
}
