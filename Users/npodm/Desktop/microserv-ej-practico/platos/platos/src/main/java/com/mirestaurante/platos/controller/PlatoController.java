
package com.mirestaurante.platos.controller;

import com.mirestaurante.platos.dto.PlatoDTO;
import com.mirestaurante.platos.model.Plato;
import com.mirestaurante.platos.service.IPlatoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platos")
public class PlatoController {
    
    @Autowired
    private IPlatoService platoServ;
    
    //  Creación: localhost:8080/platos/crear
     @PostMapping ("/crear")
     public String crearIngrediente ( @RequestBody PlatoDTO plato) {
         platoServ.savePlato(plato.getNombre() , plato.getPrecio(), plato.getDescripcion());
         return "Plato guardado correctamente";
     }

//  Lista completa de platos: localhost:8080/platos
    @GetMapping("/lista")
    public List<Plato> getPlatos() {
        return platoServ.getPlatos();
    }

//  Traer un plato  en particular: localhost:8080/platos/{id}
    @GetMapping("/{id}")
    public Plato getPlato(@PathVariable Long id) {
        return platoServ.findPlato(id);
    }

//  Eliminación: localhost:8080/platos/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public String deletePlato(@PathVariable Long id) {
        platoServ.deletePlato(id);
        return "El plato fue eliminado correctamente";
    }

//  Edición: localhost:8080/platos/editar
    @PutMapping("/editar")
    public Plato editPlato(@RequestBody Plato plat) {
        platoServ.editPlato(plat);
        return plat;
    }
}
