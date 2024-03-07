package com.mibazar.bazar.controller;

import com.mibazar.bazar.model.Producto;
import com.mibazar.bazar.service.IProductoService;
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
public class ProductoController {

    @Autowired
    private IProductoService productoServ;

//  Creación: localhost:8080/productos/crear
    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto prod) {
        productoServ.saveProducto(prod);
        return "El producto fue creado correctamente";
    }

//  Lista completa de productos: localhost:8080/productos
    @GetMapping("/productos")
    public List<Producto> getProductosList() {
        return productoServ.getProductoList();
    }

//  Traer un producto en particular: localhost:8080/productos/{codigo_producto}
    @GetMapping("/productos/{codigo_producto}")
    public Producto getProducto(@PathVariable Long codigo_producto) {
        return productoServ.findProducto(codigo_producto);
    }

//  Eliminación: localhost:8080/productos/eliminar/{codigo_producto}
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto) {
        productoServ.deleteProducto(codigo_producto);
        return "El producto fue eliminado correctamente";
    }
    
//  Edición: localhost:8080/productos/editar
    @PutMapping("/productos/editar")
    public Producto editProducto(@RequestBody Producto product) {
        productoServ.editProducto(product);
        return productoServ.findProducto(product.getCodigo_producto());
    }
    
//    Obtiene todos los productos cuya cantidad_disponible sea menor a 5: localhost:8080/productos/falta_stock
    @GetMapping("/productos/falta_stock")
    public List<Producto> getProdFaltaStock() {
        return productoServ.getProdFaltaStock();
    }
    

    
}
