package com.biblioteca.libros.repository;


import com.biblioteca.libros.model.Autor;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "autoresApi", url = "http://localhost:9002/autores")
public interface IAutoresAPIClient {

    @GetMapping("/traerLista")
    public List<Autor> getAutores();

}
