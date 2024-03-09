
package com.mirestaurante.platos.service;

import com.mirestaurante.platos.model.Plato;
import java.util.List;


public interface IPlatoService {
    
    public List<Plato> getPlatos();

    public Plato findPlato(Long id);

    public void savePlato(String nombre, Double precio, String descripcion);

    public void deletePlato(Long id);

    public void editPlato(Plato plat);
}
