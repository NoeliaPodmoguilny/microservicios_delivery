package com.mibazar.bazar.service;

import com.mibazar.bazar.model.Cliente;
import com.mibazar.bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public void saveCliente(Cliente client) {
        clienteRepo.save(client);
    }

    @Override
    public List<Cliente> getClienteList() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente findCliente(Long id_client) {
        return clienteRepo.findById(id_client).orElse(null);
    }

    @Override
    public void deleteCliente(Long id_client) {
        clienteRepo.deleteById(id_client);
    }

    @Override
    public void editCliente(Cliente client) {
        this.saveCliente(client);
    }

}
