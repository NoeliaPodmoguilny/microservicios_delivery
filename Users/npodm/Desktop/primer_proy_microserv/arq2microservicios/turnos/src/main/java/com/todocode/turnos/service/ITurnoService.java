
package com.todocode.turnos.service;

import com.todocode.turnos.model.Turno;
import java.time.LocalDate;
import java.util.List;


public interface ITurnoService {
    
    public List<Turno> getTurnos();

    public Turno findTurno(Long id);

    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente);

    public void deleteTurno(Long id);

    public void editTurno(Turno tur);
    
}
