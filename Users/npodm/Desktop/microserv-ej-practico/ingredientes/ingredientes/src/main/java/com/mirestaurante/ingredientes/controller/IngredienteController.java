
package com.mirestaurante.ingredientes.controller;

import com.mirestaurante.ingredientes.model.Ingrediente;
import com.mirestaurante.ingredientes.service.IIngredienteService;
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
@RequestMapping("/ingredientes")
public class IngredienteController {
    
    @Autowired
    private IIngredienteService ingredienteServ;
    
    //  Creación: localhost:8080/ingredientes/crear
    @PostMapping("/crear")
    public String saveIngrediente(@RequestBody Ingrediente ingre) {
        ingredienteServ.saveIngrediente(ingre);
        return "El ingrediente fue creado correctamente";
    }

//  Lista completa de ingredientes: localhost:8080/ingredientes
    @GetMapping("/lista")
    public List<Ingrediente> getIngredientes() {
        return ingredienteServ.getIngredientes();
    }

//  Traer un ingrediente  en particular: localhost:8080/ingredientes/{id}
    @GetMapping("/{id}")
    public Ingrediente getIngrediente(@PathVariable Long id) {
        return ingredienteServ.findIngrediente(id);
    }

//  Eliminación: localhost:8080/ingredientes/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public String deleteIngrediente(@PathVariable Long id) {
        ingredienteServ.deleteIngrediente(id);
        return "El ingrediente fue eliminado correctamente";
    }

//  Edición: localhost:8080/ingredientes/editar
    @PutMapping("/editar")
    public Ingrediente editIngrediente(@RequestBody Ingrediente ingre) {
        ingredienteServ.editIngrediente(ingre);
        return ingre;
    }
    
    @GetMapping ("/traer/{nombrePlato}")
    public List<Ingrediente> traerIngredientesByPlato (@PathVariable String nombrePlato) {
        return ingredienteServ.getIngredienteByPlato(nombrePlato);
    }
    
}
