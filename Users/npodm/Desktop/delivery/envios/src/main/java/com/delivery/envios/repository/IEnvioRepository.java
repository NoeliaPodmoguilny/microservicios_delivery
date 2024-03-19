
package com.delivery.envios.repository;

import com.delivery.envios.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnvioRepository extends  JpaRepository<Envio, Long>{
    
}
