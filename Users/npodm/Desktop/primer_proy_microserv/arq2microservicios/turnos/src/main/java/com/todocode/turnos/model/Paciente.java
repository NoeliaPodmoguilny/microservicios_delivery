package com.todocode.turnos.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    private Long idPaciente;
    private String dni;
    private String nombre;
    private String apellido;
    private Date fechaNac;
    private String telefono;

}
