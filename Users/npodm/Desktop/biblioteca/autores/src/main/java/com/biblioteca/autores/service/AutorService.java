package com.biblioteca.autores.service;

import com.biblioteca.autores.model.Autor;
import com.biblioteca.autores.repository.IAutorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService implements IAutoresService {

    @Autowired
    private IAutorRepository autorRepo;

    @Override
    public void saveAutor(Autor autor) {
        autorRepo.save(autor);
    }

    @Override
    public List<Autor> getAutores() {
        return autorRepo.findAll();
    }

    @Override
    public Autor findAutor(Long id) {
        return autorRepo.findById(id).orElse(null);
    }

}
