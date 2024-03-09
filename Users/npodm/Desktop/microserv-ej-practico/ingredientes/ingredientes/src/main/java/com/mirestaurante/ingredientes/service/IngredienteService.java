
package com.mirestaurante.ingredientes.service;

import com.mirestaurante.ingredientes.model.Ingrediente;
import com.mirestaurante.ingredientes.repository.IIngredienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService implements IIngredienteService{

    @Autowired
    private IIngredienteRepository ingredienteRepo;
     
    @Override
    public List<Ingrediente> getIngredientes() {
        return ingredienteRepo.findAll();
    }

    @Override
    public Ingrediente findIngrediente(Long id) {
        return ingredienteRepo.findById(id).orElse(null);
    }

    @Override
    public void saveIngrediente(Ingrediente ingre) {
        ingredienteRepo.save(ingre);
    }

    @Override
    public void deleteIngrediente(Long id) {
        ingredienteRepo.deleteById(id);
    }

    @Override
    public void editIngrediente(Ingrediente ingre) {
        this.saveIngrediente(ingre);
    }

    @Override
    public List<Ingrediente> getIngredienteByPlato(String nombrePlato) {
        List<Ingrediente> listaIngredientes = ingredienteRepo.findByNombre(nombrePlato);        
        return listaIngredientes;
    }
    
}
