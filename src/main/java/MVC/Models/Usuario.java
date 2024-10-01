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
public class Usuario {
    private int id_usuario;
    private String mail;
    private String pass;
    private String rol;
    
}
