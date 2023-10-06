/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;

import MVC.Models.Combo;
import MVC.Models.Pedido;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Tomas
 */
public class ComboDAO {
     
    List<Combo> combos;
    
    
    public List<Combo> getAllCombos() {
 
        //colocar los datos de su  servidor de Mysql (root) y contrasea (adminadmin)
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "agus", "a");

        try (Connection con = sql2o.open()) {
           
            String sql = "SELECT * FROM combos";

            combos = con
                .createQuery(sql)
                .executeAndFetch(Combo.class);
        }
        catch(Exception e) {
            System.out.println(e);}
        

        return combos;
    }
    
   
    
    public void cargarCombo(Combo combo){
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "agus", "a");
          
        try (Connection con = sql2o.open()) {
           
            String sql = "INSERT INTO combos VALUES(:id_combo, :id_comestible, :cantComida, :id_bebida , :cantBebida, :precio, :descripcion, :visible)";
            con.createQuery(sql)
                .bind(combo)
                .executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);}
    }
}
