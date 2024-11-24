/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;

import MVC.Models.Combo;
import MVC.Models.Pedido;
import Service.Isql2oDAO;
import Utils.Sql2oDAO;

import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Tomas
 */

public class ComboDAO {
     
    List<Combo> combos;
    Isql2oDAO sql2o; 
    public ComboDAO(Isql2oDAO sql2oDAO) {
        this.sql2o = sql2oDAO; // Inyección de dependencia
    }  
    
    public List<Combo> getAllCombos() {     

        try (Connection con = sql2o.getSql2o().open()) {
           
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
    
        try (Connection con = sql2o.getSql2o().open()) {
           
            String sql = "INSERT INTO combos VALUES(:id_combo, :nombre, :id_comida, :cantComida, :id_bebida , :cantBebida, :precio, :descripcion, :visible)";
            con.createQuery(sql)
                .bind(combo)
                .executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);}
    }
}
