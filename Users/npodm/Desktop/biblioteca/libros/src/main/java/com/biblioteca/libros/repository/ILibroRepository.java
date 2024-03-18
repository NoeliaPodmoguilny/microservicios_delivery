
package com.biblioteca.libros.repository;

import com.biblioteca.libros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ILibroRepository extends JpaRepository<Libro, Long>{
    
}
