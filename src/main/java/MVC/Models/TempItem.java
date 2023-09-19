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
public class TempItem {
    private String cantidad;
    private String id;
    
    public String getId() { return this.id; }
    public void setId(String id) { this.id = id; }
    public String getCantidad() {return this.cantidad;}
    public void setCantidad(String cantidad) {this.cantidad = cantidad;};
}
