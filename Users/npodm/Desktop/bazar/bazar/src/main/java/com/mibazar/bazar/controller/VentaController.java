package com.mibazar.bazar.controller;

import com.mibazar.bazar.dto.ProductosPorVentaDTO;
import com.mibazar.bazar.model.Producto;
import com.mibazar.bazar.model.Venta;
import com.mibazar.bazar.service.IVentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaServ;

//  Creación: localhost:8080/ventas/crear
    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta vent) {
        ventaServ.saveVenta(vent);
        return "La venta fue creada correctamente";
    }

//  Lista completa de ventas: localhost:8080/ventas
    @GetMapping("/ventas")
    public List<Venta> getVentasList() {
        return ventaServ.getVentaList();
    }

//  Traer un venta en particular: localhost:8080/ventas/{codigo_venta}
    @GetMapping("/ventas/{codigo_venta}")
    public Venta getVenta(@PathVariable Long codigo_venta) {
        return ventaServ.findVenta(codigo_venta);
    }

//  Eliminación: localhost:8080/ventas/eliminar/{codigo_venta}
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta) {
        ventaServ.deleteVenta(codigo_venta);
        return "La venta fue eliminada correctamente";
    }

//  Edición: localhost:8080/ventas/editar
    @PutMapping("/ventas/editar")
    public Venta editVenta(@RequestBody Venta vent) {
        ventaServ.editVenta(vent);
        return ventaServ.findVenta(vent.getCodigo_venta());
    }

    //    Obtener la lista de productos de una determinada venta: localhost:8080/ventas/productos/{codigo_venta}
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getProdCodVenta(@PathVariable Long codigo_venta) {
        return ventaServ.getProdCodVenta(codigo_venta);
    }

//    Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día: localhost:8080/ventas/{fecha_venta}
    @GetMapping("/ventas/montopordia/{fecha_venta}")
    public String getMontoPorDia(@PathVariable String fecha_venta) {
        return ventaServ.getMontoPorDia(fecha_venta);
    }

    //Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el apellido del cliente de la venta con el monto más alto de todas: localhost:8080/ventas/mayor_venta
    @GetMapping("/ventas/mayor_venta")
    public ProductosPorVentaDTO getMayorVenta() {
        return ventaServ.getMayorVenta();
    }
}
