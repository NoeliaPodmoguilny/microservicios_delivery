package com.mibazar.bazar.service;

import com.mibazar.bazar.dto.ProductosPorVentaDTO;
import com.mibazar.bazar.model.Producto;
import com.mibazar.bazar.model.Venta;
import java.util.List;

public interface IVentaService {

    //  Crea una Venta
    public void saveVenta(Venta vent);

//  Trae lista completa de Ventas
    public List<Venta> getVentaList();

//  Traer una Venta en particular por id
    public Venta findVenta(Long id_vent);

//  Elimina una Venta por id
    public void deleteVenta(Long id_vent);

//  Edita una Venta 
    public void editVenta(Venta vent);
    
//    Lista de productos segun codigo_venta
    public List<Producto> getProdCodVenta(Long codigo_venta);

    public String  getMontoPorDia(String fecha_venta);

    public ProductosPorVentaDTO getMayorVenta();

}
