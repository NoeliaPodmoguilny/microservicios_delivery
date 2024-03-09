package com.todocode.turnos.controller;

import com.todocode.turnos.dto.TurnoDTO;
import com.todocode.turnos.model.Turno;
import com.todocode.turnos.service.ITurnoService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoServ;

//  Creación: localhost:8080/turnos/crear
    @PostMapping("/crear")
    public String saveTurno(@RequestBody TurnoDTO turno) {        
        turnoServ.saveTurno(turno.getFecha(), turno.getTratamiento(), turno.getDniPaciente());
        return "El turno fue creado correctamente";
    }

//  Lista completa de turnos: localhost:8080/turnos
    @GetMapping("/traerLista")
    public List<Turno> getTurnos() {
        return turnoServ.getTurnos();
    }

//  Traer un turno  en particular: localhost:8080/turnos/{id}
    @GetMapping("/{id}")
    public Turno getTurno(@PathVariable Long id) {
        return turnoServ.findTurno(id);
    }

//  Eliminación: localhost:8080/turnos/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public String deleteTurno(@PathVariable Long id) {
        turnoServ.deleteTurno(id);
        return "El turno fue eliminado correctamente";
    }

//  Edición: localhost:8080/turnos/editar
    @PutMapping("/editar")
    public Turno editTurno(@RequestBody Turno turnoEditar) {
        turnoServ.editTurno(turnoEditar);
        return turnoEditar;
    }
}
