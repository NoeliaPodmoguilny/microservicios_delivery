package com.mibazar.bazar.dto;

import com.mibazar.bazar.model.Producto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductosPorVentaDTO {

    private Long codigo_venta;
    private Double total;
    private List<Producto> cantidad_prod;
    private String nombre_cliente;
    private String apellido_cliente;

    public ProductosPorVentaDTO() {
    }

    public ProductosPorVentaDTO(Long codigo_venta, Double total, List<Producto> cantidad_prod, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidad_prod = cantidad_prod;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }

}
