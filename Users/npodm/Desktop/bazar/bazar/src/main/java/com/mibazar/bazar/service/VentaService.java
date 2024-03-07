package com.mibazar.bazar.service;

import com.mibazar.bazar.dto.ProductosPorVentaDTO;
import com.mibazar.bazar.model.Producto;
import com.mibazar.bazar.model.Venta;
import com.mibazar.bazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public void saveVenta(Venta vent) {
        ventaRepo.save(vent);
    }

    @Override
    public List<Venta> getVentaList() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta findVenta(Long id_vent) {
        return ventaRepo.findById(id_vent).orElse(null);
    }

    @Override
    public void deleteVenta(Long id_vent) {
        ventaRepo.deleteById(id_vent);
    }

    @Override
    public void editVenta(Venta vent) {
        this.saveVenta(vent);
    }

    @Override
    public List<Producto> getProdCodVenta(Long codigo_venta) {
        Venta vent = ventaRepo.findById(codigo_venta).orElse(null);

        if (vent != null) {
            return vent.getListaProductos();
        } else {
            // Si la venta no se encuentra con ese codigo:
            throw new RuntimeException("No se encontró la venta con el código: " + codigo_venta);
        }
    }

    @Override
    public String getMontoPorDia(String fecha_venta) {

        // Formato del string
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Parsear el string a LocalDate
        LocalDate fechaVenta = LocalDate.parse(fecha_venta, formato);
        Double montoTotal = 0.0;
        int cantidadVentas = 0;

        List<Venta> listaVentas = this.getVentaList();

        for (Venta vent : listaVentas) {
            if (vent.getFecha_venta().equals(fechaVenta)) {
                cantidadVentas++;
                montoTotal += vent.getTotal();
            }
        }
        return "El monto total recaudado en el día " + fechaVenta + " es: " + montoTotal + ", y la cantidad de ventas fueron: " + cantidadVentas; //aca retorna montoTotal y cantidadVentas
    }

    @Override
    public ProductosPorVentaDTO getMayorVenta() {
        
        // Buscamos la venta con mayor monto
        List<Venta> listaVentas = this.getVentaList();
        Double auxMayor=0.0;
        Long cod_venta= null;
        
        for(Venta v:listaVentas){
            if(v.getTotal()>auxMayor){
                auxMayor=v.getTotal();
                cod_venta=v.getCodigo_venta();
            }
        }
        //traemos la venta con el codigo
        Venta vmayor = this.findVenta(cod_venta);
        
        ProductosPorVentaDTO datosDTO = new ProductosPorVentaDTO();
        //seteamos los valores del dto
            datosDTO.setCodigo_venta(cod_venta);
            datosDTO.setTotal(vmayor.getTotal());
            datosDTO.setCantidad_prod(vmayor.getListaProductos());
            datosDTO.setNombre_cliente(vmayor.getUnCliente().getNombre());
            datosDTO.setApellido_cliente(vmayor.getUnCliente().getApellido());
        
        return datosDTO;
    }

}
