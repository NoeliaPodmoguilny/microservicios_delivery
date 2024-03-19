
package com.delivery.destinatarios.service;

import com.delivery.destinatarios.dto.DatosEnvioDTO;
import com.delivery.destinatarios.model.Destinatario;
import java.util.List;

public interface IDestinatarioService {

    public void saveDestinatario(Destinatario client);

    public List<Destinatario> getDestinatarioList();

    public Destinatario findDestinatario(Long id_destinatario);

    public void deleteDestinatario(Long id_destinatario);

    public void editDestinatario(Destinatario client);
    
    public DatosEnvioDTO getDatosEnvio(Long id_destinatario);
    
}
