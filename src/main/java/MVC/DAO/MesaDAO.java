/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;

import MVC.Models.Mesa;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Tomas
 */
public class MesaDAO {
    
     private List<Mesa> mesas;
    
    public List<Mesa> obtenerMesas() {

        //colocar los datos de su  servidor de Mysql (root) y contrasea (adminadmin)
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "agus", "a");

        try (Connection con = sql2o.open()) {
            
            System.out.println(sql2o);
            String sql = "SELECT * FROM mesa";

            mesas = con
                .createQuery(sql)
                .executeAndFetch(Mesa.class);
        }
        catch(Exception e) {
            System.out.println(e);}
        return mesas;
    }
    
}
