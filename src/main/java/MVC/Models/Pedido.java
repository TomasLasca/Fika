/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Models;
import lombok.Data;
/**
 *
 * @author fikaneta
 */
@Data
public class Pedido {
    private int id_usuario;
    private int nro_pedido;
    private String fecha_pedido;
    private String hora_pedido;
    private int id_estado;
    private int id_metodo;
}
