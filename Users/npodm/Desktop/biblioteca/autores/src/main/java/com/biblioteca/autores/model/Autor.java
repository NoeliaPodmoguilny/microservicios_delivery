package com.biblioteca.autores.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre_completo;
    private String nacionalidad;
    private Date fecha_nac;
    private List<Long> idLibros;

    public Autor() {
    }

    public Autor(Long id, String nombre_completo, String nacionalidad, Date fecha_nac, List<Long> idLibros) {
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.nacionalidad = nacionalidad;
        this.fecha_nac = fecha_nac;
        this.idLibros = idLibros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public List<Long> getIdLibros() {
        return idLibros;
    }

    public void setIdLibros(List<Long> idLibros) {
        this.idLibros = idLibros;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre_completo=" + nombre_completo + ", nacionalidad=" + nacionalidad + ", fecha_nac=" + fecha_nac + ", idLibros=" + idLibros + '}';
    }

    
}
