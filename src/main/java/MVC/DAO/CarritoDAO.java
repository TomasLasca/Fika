/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;
import MVC.Models.Carrito;
import MVC.Models.Producto;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


/**
 *
 * @author Martin
 */
public class CarritoDAO {
    private List<Carrito> carritos;
    
    public List<Carrito> getAllCarrito() {

        //colocar los datos de su  servidor de Mysql (root) y contrasea (adminadmin)
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "root", "");

        try (Connection con = sql2o.open()) {
           
            String sql = "SELECT * FROM carrito";

            carritos = con
                .createQuery(sql)
                .executeAndFetch(Carrito.class);
        }
        catch(Exception e) {
            System.out.println(e);}
        

        return carritos;
    }
    
        public List<Carrito> getCarritoByUserId(int id) {
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "root", "");
     
        try (Connection con = sql2o.open()) {
           
            String sql = "SELECT * FROM carrito WHERE id_usuario = :id";

            carritos = con
                .createQuery(sql)
                .addParameter("id", id)
                .executeAndFetch(Carrito.class);
        }
        catch(Exception e) {
            System.out.println(e);}
        
        return carritos;
    }

}
