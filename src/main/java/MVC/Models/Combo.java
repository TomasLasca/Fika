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
public class Combo {
    
    private int id_combo;
    private int id_comestible;
    private int cantComida;
    private int id_bebida;
    private int cantBebida;
    private int precio;
    private String descripcion;
    private String nombre;
    private String visible;
    
}
