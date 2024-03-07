
package com.mibazar.bazar.service;

import com.mibazar.bazar.model.Producto;
import com.mibazar.bazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public void saveProducto(Producto prod) {
        productoRepo.save(prod);
    }

    @Override
    public List<Producto> getProductoList() {
        return productoRepo.findAll();
    }

    @Override
    public Producto findProducto(Long id_prod) {
        return productoRepo.findById(id_prod).orElse(null);
    }

    @Override
    public void deleteProducto(Long id_prod) {
        productoRepo.deleteById(id_prod);
    }

    @Override
    public void editProducto(Producto prod) {
       this.saveProducto(prod);
    }

    @Override
    public List<Producto> getProdFaltaStock() {
        List<Producto> listaProdFaltantes = new ArrayList<Producto>();
        List<Producto> listaProductos = this.getProductoList();
        
        for(Producto prod:listaProductos){
            if(prod.getCantidad_disponible()<5.00){
                listaProdFaltantes.add(prod);
            }
        }

        return listaProdFaltantes;        
    }
    
}
