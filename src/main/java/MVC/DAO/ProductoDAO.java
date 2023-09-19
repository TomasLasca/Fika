/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;

import MVC.Models.Producto;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Tomas
 */
public class ProductoDAO {
    
    private List<Producto> productos;


    public List<Producto> obtenerProductos() {

        //colocar los datos de su  servidor de Mysql (root) y contrasea (adminadmin)
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "agus", "a");

        try (Connection con = sql2o.open()) {
           
            String sql = "SELECT * FROM productos";

            productos = con
                .createQuery(sql)
                .executeAndFetch(Producto.class);
        }
        catch(Exception e) {
            System.out.println(e);}
        

        return productos;
    }
    
    public List<Producto> obtenerProductoId(int id) {
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "agus", "a");
     
        try (Connection con = sql2o.open()) {
           
            String sql = "SELECT * FROM productos WHERE id = :id";

            productos = con
                .createQuery(sql)
                .addParameter("id", id)
                .executeAndFetch(Producto.class);
        }
        catch(Exception e) {
            System.out.println(e);}
        
        return productos;
    }
    
    
}
