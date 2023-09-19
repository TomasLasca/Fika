/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Models;


import lombok.Data;
/**
 *
 * @author Tomas
 */
@Data
public class Producto {
    private int stock;
    private int id;
    private String nombre;
    private String categoria;
    private String foto;
    private Double precio_vta;
    private String descripcion_producto;
}
