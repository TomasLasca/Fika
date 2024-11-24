/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;

import MVC.Models.Reserva;
import Service.Isql2oDAO;
import org.sql2o.Connection;



public class ReservaDAO {
    private final Isql2oDAO bd; // Referencia a la interfaz
    
    public ReservaDAO(Isql2oDAO sql2oDAO) {
        this.bd = sql2oDAO; // Inyección de dependencia
    }
    public void realizar_reserva(Reserva reserva){
  
        
        try (Connection con = bd.getSql2o().open()) {
           
            String sql = "INSERT INTO reserva VALUES(:nro_reserva, :fecha_reserva, :sillas, :hora,:nombre)";
            con.createQuery(sql)
                .bind(reserva)
                .executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);}
        
    }
    
}
