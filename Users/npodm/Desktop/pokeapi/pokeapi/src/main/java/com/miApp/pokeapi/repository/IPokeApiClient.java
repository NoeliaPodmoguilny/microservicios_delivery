
package com.miApp.pokeapi.repository;

import com.miApp.pokeapi.dto.PokemonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokeapi", url = "https://pokeapi.co/api/v2")
public interface IPokeApiClient {
    
    @GetMapping("/pokemon/{pokemonId}")
    public PokemonDTO getPokemonInfo(@PathVariable ("pokemonId") int pokemonId);
}
