package com.delivery.destinatarios.dto;

import java.util.Date;

public class DatosEnvioDTO {

    private Long id_envio;
    private Date fecha;
    private String estado;
    private String descripcion_paquete;
    private Long id_cliente;

    public DatosEnvioDTO() {
    }

    public DatosEnvioDTO(Long id_envio, Date fecha, String estado, String descripcion_paquete, Long id_cliente) {
        this.id_envio = id_envio;
        this.fecha = fecha;
        this.estado = estado;
        this.descripcion_paquete = descripcion_paquete;
        this.id_cliente = id_cliente;
    }

    public Long getId_envio() {
        return id_envio;
    }

    public void setId_envio(Long id_envio) {
        this.id_envio = id_envio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion_paquete() {
        return descripcion_paquete;
    }

    public void setDescripcion_paquete(String descripcion_paquete) {
        this.descripcion_paquete = descripcion_paquete;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "DatosEnvioDTO{" + "id_envio=" + id_envio + ", fecha=" + fecha + ", estado=" + estado + ", descripcion_paquete=" + descripcion_paquete + ", id_cliente=" + id_cliente + '}';
    }
    
    

}
