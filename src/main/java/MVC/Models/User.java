/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Models;

/**
 *
 * @author USUARIO
 */

import lombok.Data;

@Data
public class User {
    private int id_usuario;
    private String nombre_usuario;
    private String email;
    private String pass;
    private String tipo_usuario;
}
