package com.mibazar.bazar.controller;

import com.mibazar.bazar.model.Cliente;
import com.mibazar.bazar.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteServ;

//  Creación: localhost:8080/clientes/crear
    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente client) {
        clienteServ.saveCliente(client);
        return "El cliente fue creado correctamente";
    }

//  Lista completa de clientes: localhost:8080/clientes
    @GetMapping("/clientes")
    public List<Cliente> getClientesList() {
        return clienteServ.getClienteList();
    }

//  Traer un cliente  en particular: localhost:8080/clientes/{id_cliente}
    @GetMapping("/clientes/{id_cliente}")
    public Cliente getCliente(@PathVariable Long id_cliente) {
        return clienteServ.findCliente(id_cliente);
    }

//  Eliminación: localhost:8080/clientes/eliminar/{id_cliente}
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente) {
        clienteServ.deleteCliente(id_cliente);
        return "El cliente fue eliminado correctamente";
    }

//  Edición: localhost:8080/clientes/editar
    @PutMapping("/clientes/editar")
    public Cliente editCliente(@RequestBody Cliente client) {
        clienteServ.editCliente(client);
        return clienteServ.findCliente(client.getId_cliente());
    }

}
