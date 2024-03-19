package com.delivery.envios.service;

import com.delivery.envios.model.Envio;
import com.delivery.envios.repository.IEnvioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnvioService implements IEnvioService{

    @Autowired
    private IEnvioRepository envioRepo;

    @Override
    public void saveEnvio(Envio envio) {
        envioRepo.save(envio);
    }

    @Override
    public List<Envio> getEnvioList() {
        return envioRepo.findAll();
    }

    @Override
    public Envio findEnvio(Long id_envio) {
        return envioRepo.findById(id_envio).orElse(null);
    }

    @Override
    public void deleteEnvio(Long id_envio) {
        envioRepo.deleteById(id_envio);
    }

    @Override
    public void editEnvio(Envio envio) {
        this.saveEnvio(envio);
    }
    
}
