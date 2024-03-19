package com.delivery.destinatarios.controller;

import com.delivery.destinatarios.dto.DatosEnvioDTO;
import com.delivery.destinatarios.model.Destinatario;
import com.delivery.destinatarios.service.IDestinatarioService;
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
@RequestMapping("/destinatarios")
public class DestinatarioController {

    @Autowired
    private IDestinatarioService destinatarioServ;

//  Crear
    @PostMapping("/crear")
    public String saveDestinatario(@RequestBody Destinatario client) {
        destinatarioServ.saveDestinatario(client);
        return "El destinatario fue creado correctamente";
    }

//  Lista completa de destinatarios
    @GetMapping("/traerLista")
    public List<Destinatario> getDestinatariosList() {
        return destinatarioServ.getDestinatarioList();
    }

//  Traer un destinatario  en particular por id
    @GetMapping("/traer/{id_destinatario}")
    public Destinatario getDestinatario(@PathVariable Long id_destinatario) {
        return destinatarioServ.findDestinatario(id_destinatario);
    }

//  Eliminar
    @DeleteMapping("/eliminar/{id_destinatario}")
    public String deleteDestinatario(@PathVariable Long id_destinatario) {
        destinatarioServ.deleteDestinatario(id_destinatario);
        return "El destinatario fue eliminado correctamente";
    }

//  Editar
    @PutMapping("/editar")
    public Destinatario editDestinatario(@RequestBody Destinatario client) {
        destinatarioServ.editDestinatario(client);
        return destinatarioServ.findDestinatario(client.getId_destinatario());
    }
    
    
//    trae dato del envio segun id de destinatario
    @GetMapping("/traerEnvio/{id_destinatario}")
    public DatosEnvioDTO getDatosEnvio(@PathVariable Long id_destinatario) {
        return destinatarioServ.getDatosEnvio(id_destinatario);
    }
}
