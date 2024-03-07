package com.mibazar.bazar.service;

import com.mibazar.bazar.model.Producto;
import java.util.List;

public interface IProductoService {

//  Crea un producto
    public void saveProducto(Producto prod);

//  Trae lista completa de productos
    public List<Producto> getProductoList();

//  Traer un producto en particular por id
    public Producto findProducto(Long id_prod);

//  Elimina un producto por id
    public void deleteProducto(Long id_prod);

//  Edita un producto 
    public void editProducto(Producto prod);

    public List<Producto> getProdFaltaStock();

    

}
