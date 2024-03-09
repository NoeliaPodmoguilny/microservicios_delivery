
package com.mirestaurante.ingredientes.service;

import com.mirestaurante.ingredientes.model.Ingrediente;
import java.util.List;

public interface IIngredienteService {
    
    public List<Ingrediente> getIngredientes();

    public Ingrediente findIngrediente(Long id);

    public void saveIngrediente(Ingrediente ingre);

    public void deleteIngrediente(Long id);

    public void editIngrediente(Ingrediente ingre);

    public List<Ingrediente> getIngredienteByPlato (String nombrePlato);
}
