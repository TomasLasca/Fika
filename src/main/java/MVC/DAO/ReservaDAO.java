/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;

import MVC.Models.Reserva;
import Utils.Sql2oDAO;
import static Utils.Sql2oDAO.getSql2o;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Tomas
 */
public class ReservaDAO {
    
    public void realizar_reserva(Reserva reserva){
        Sql2o bd;
        bd = getSql2o();
        
        try (Connection con = bd.open()) {
           
            String sql = "INSERT INTO reserva VALUES(:nro_reserva, :fecha_reserva, :sillas, :hora,:nombre)";
            con.createQuery(sql)
                .bind(reserva)
                .executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);}
        
    }
    
}
