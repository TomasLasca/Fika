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
public class Mesa {
    private int nro_mesa;
    private int cant_sillas;  
    private Date fecha_disponible;   
}
