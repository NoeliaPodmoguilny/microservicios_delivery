package com.delivery.envios.controller;

import com.delivery.envios.model.Envio;
import com.delivery.envios.service.IEnvioService;
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
@RequestMapping("/envios")
public class EnvioController {

    @Autowired
    private IEnvioService envioServ;

//  Crear
    @PostMapping("/crear")
    public String saveEnvio(@RequestBody Envio envio) {
        envioServ.saveEnvio(envio);
        return "El envio fue creado correctamente";
    }

//  Lista completa de envios
    @GetMapping("/traerLista")
    public List<Envio> getEnviosList() {
        return envioServ.getEnvioList();
    }

//  Traer un envio  en particular por id
    @GetMapping("/traer/{id_envio}")
    public Envio getEnvio(@PathVariable Long id_envio) {
        return envioServ.findEnvio(id_envio);
    }

//  Eliminar
    @DeleteMapping("/eliminar/{id_envio}")
    public String deleteEnvio(@PathVariable Long id_envio) {
        envioServ.deleteEnvio(id_envio);
        return "El envio fue eliminado correctamente";
    }

//  Editar
    @PutMapping("/editar")
    public Envio editEnvio(@RequestBody Envio envio) {
        envioServ.editEnvio(envio);
        return envioServ.findEnvio(envio.getId_envio());
    }
}
