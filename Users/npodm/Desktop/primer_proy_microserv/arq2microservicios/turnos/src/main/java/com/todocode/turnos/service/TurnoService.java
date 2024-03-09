package com.todocode.turnos.service;

import com.todocode.turnos.model.Paciente;
import com.todocode.turnos.model.Turno;
import com.todocode.turnos.repository.ITurnoRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepo;
    
    @Autowired
    private RestTemplate apiConsumir; //<- mismo nombre que en el @Bean()

    @Override
    public List<Turno> getTurnos() {
        return turnoRepo.findAll();
    }

    @Override
    public Turno findTurno(Long id) {
        return turnoRepo.findById(id).orElse(null);
    }

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {

        //buscar el paciente en la api paciente
        Paciente pac = apiConsumir.getForObject("http://localhost:9001/pacientes/traerdni/"+dniPaciente, Paciente.class);
        //obtengo el nombre completo
         String nombreCompletoPaciente = pac.getNombre()+" "+pac.getApellido();
        Turno tur = new Turno();
        tur.setFecha(fecha);
        tur.setTratamiento(tratamiento);
        tur.setNombreCompletoPaciente(nombreCompletoPaciente);

        turnoRepo.save(tur);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepo.deleteById(id);
    }

    @Override
    public void editTurno(Turno tur) {
        turnoRepo.save(tur);
    }

}
