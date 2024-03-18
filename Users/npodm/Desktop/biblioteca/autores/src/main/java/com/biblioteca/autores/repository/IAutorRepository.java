
package com.biblioteca.autores.repository;

import com.biblioteca.autores.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAutorRepository extends JpaRepository<Autor, Long>{
    
}
