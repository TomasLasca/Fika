/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Models;

import lombok.Data;

/**
 *
 * @author Martin
 */
@Data
public class Detalle {
    Producto producto;
    int cantidad;
    
    public Detalle(Producto p, int cant){
        this.producto = p;
        this.cantidad = cant;
    }
    
    public double getTotal() { 
    return (this.producto.getPrecio_vta() + this.cantidad);
    }
}
