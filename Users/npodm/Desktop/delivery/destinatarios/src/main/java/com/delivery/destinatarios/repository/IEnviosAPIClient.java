package com.delivery.destinatarios.repository;

import com.delivery.destinatarios.dto.DatosEnvioDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "enviosAPI", url = "http://localhost:9001/envios")
public interface IEnviosAPIClient {

    @GetMapping("/traerLista")
    public List<DatosEnvioDTO> getEnviosList();
    
}
