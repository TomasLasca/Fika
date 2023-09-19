/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Models;
import java.util.Date;
import lombok.Data;
/**
 *
 * @author Tomas
 */
@Data
public class Reserva {
    private int nro_reserva;
    private String fecha_reserva;
    private String nombre;
    private int sillas;
    private String hora;
}
