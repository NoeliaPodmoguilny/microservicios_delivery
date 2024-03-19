package com.delivery.destinatarios.service;

import com.delivery.destinatarios.dto.DatosEnvioDTO;
import com.delivery.destinatarios.model.Destinatario;
import com.delivery.destinatarios.repository.IDestinatarioRepository;
import com.delivery.destinatarios.repository.IEnviosAPIClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinatarioService implements IDestinatarioService {

    @Autowired
    private IDestinatarioRepository destinatRepo;

    @Autowired
    private IEnviosAPIClient APIClient;

    //falta agregar apiclient y editar el metodo al crear nuevo destinat
    @Override
    public void saveDestinatario(Destinatario client) {
        destinatRepo.save(client);
    }

    @Override
    public List<Destinatario> getDestinatarioList() {
        return destinatRepo.findAll();
    }

    @Override
    public Destinatario findDestinatario(Long id_destinatario) {
        return destinatRepo.findById(id_destinatario).orElse(null);
    }

    @Override
    public void deleteDestinatario(Long id_destinatario) {
        destinatRepo.deleteById(id_destinatario);
    }

    @Override
    public void editDestinatario(Destinatario client) {
        this.saveDestinatario(client);
    }

    @Override
    public DatosEnvioDTO getDatosEnvio(Long id_destinatario) {

        List<DatosEnvioDTO> listaEnvios = APIClient.getEnviosList();

        DatosEnvioDTO envioDestinatario = new DatosEnvioDTO();

        for (DatosEnvioDTO envio : listaEnvios) {
            if (envio.getId_cliente().equals(id_destinatario)) {
                envioDestinatario = envio;
            }
        }

        return envioDestinatario;
    }

}
