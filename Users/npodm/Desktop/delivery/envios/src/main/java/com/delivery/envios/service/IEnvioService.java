
package com.delivery.envios.service;

import com.delivery.envios.model.Envio;
import java.util.List;


public interface IEnvioService {

    public void saveEnvio(Envio envio);

    public List<Envio> getEnvioList();

    public Envio findEnvio(Long id_envio);

    public void deleteEnvio(Long id_envio);

    public void editEnvio(Envio envio);
    
}
