package com.miApp.pokeapi.controller;

import com.miApp.pokeapi.dto.PokemonDTO;
import com.miApp.pokeapi.repository.IPokeApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    @Autowired
    private IPokeApiClient pokeClient;

    @GetMapping("/pokemon/{pokemonId}")
    public PokemonDTO getPokemonIndo(@PathVariable("pokemonId") int pokemonId) {
        return pokeClient.getPokemonInfo(pokemonId);
    }

}
