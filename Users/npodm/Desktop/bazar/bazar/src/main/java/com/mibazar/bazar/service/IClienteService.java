package com.mibazar.bazar.service;

import com.mibazar.bazar.model.Cliente;
import java.util.List;

public interface IClienteService {

    //  Crea un Cliente
    public void saveCliente(Cliente client);

//  Trae lista completa de Cliente
    public List<Cliente> getClienteList();

//  Traer un Cliente en particular por id
    public Cliente findCliente(Long id_client);

//  Elimina un Cliente por id
    public void deleteCliente(Long id_client);

//  Edita un Cliente 
    public void editCliente(Cliente client);
}
