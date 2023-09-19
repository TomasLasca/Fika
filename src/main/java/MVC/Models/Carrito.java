/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Models;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Tomas
 */

@Data
public class Carrito{
    private int id_usuario;
    private int id_carrito;

    /*List<ItemCarrito> listaCarrito;
    int cantidad_productos = 0;
    
    public Carrito() {
        listaCarrito = new ArrayList<>(0);
    }
            
    public ItemCarrito addItem(Producto p, int cant){
        ItemCarrito new_item = new ItemCarrito(p,cant);
        this.cantidad_productos++;
        boolean find = false;
        
        for(ItemCarrito item: listaCarrito) {
            if(item.getProducto().getId() == p.getId()) {
                find = true;
                new_item = item;
                item.actualizarCantidad(cant);
            } 
        }
        
        if (!find) {
           this.listaCarrito.add(new_item); 
        }
        
        return new_item;

    }
    
    public void removeItem(ItemCarrito p){
        
        listaCarrito.remove(p);
        
    }
    
    public int calcularTotal(){
        int total=0;
        for(int i=0;i<listaCarrito.size();i++){
            total += listaCarrito.get(i).getProducto().getPrecio_vta() * listaCarrito.get(i).getCantidad();
        }
        
        return total;
    }
   */ 
}
