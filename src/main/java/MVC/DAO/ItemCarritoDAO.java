/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;

import MVC.Models.ItemCarrito;
import MVC.Models.Pedido;
import MVC.Models.Producto;
import static Utils.Sql2oDAO.getSql2o;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Tomas
 */
public class ItemCarritoDAO {
    
    private List<ItemCarrito> items;
    
    public List<ItemCarrito> obtenerItemsByCarritoId(int id) {
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "root", "");
     
        try (Connection con = sql2o.open()) {
           
            String sql = "SELECT * FROM itemcarrito WHERE id_carrito = :id";

            items = con
                .createQuery(sql)
                .addParameter("id", id)
                .executeAndFetch(ItemCarrito.class);
        }
        catch(Exception e) {
            System.out.println(e);}
        
        return items;
    }
    
    public void cargarItemCarrito(ItemCarrito item){
        Sql2o bd;
        bd = getSql2o();
        
        try (Connection con = bd.open()) {
           
            String sql = "INSERT INTO itemcarrito VALUES(:id_carrito, :id_producto, :cantidad )";
            con.createQuery(sql)
                .bind(item)
                .executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);}
    }
    
    public void actualizarItemCarrito(int id_carrito, int id_producto, int cantidad) {
        Sql2o bd;
        bd = getSql2o();
        
        try (Connection con = bd.open()) {
         
            String sql = "UPDATE itemcarrito SET cantidad = :cantidad where id_carrito = :id_carrito and id_producto = :id_producto";
            con.createQuery(sql)
                .addParameter("id_carrito", id_carrito)
                .addParameter("id_producto", id_producto)
                .addParameter("cantidad", cantidad)
                .executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);}

    }
    
        public void clearItemCarrito(int id_carrito) {
        Sql2o bd;
        bd = getSql2o();
        
        try (Connection con = bd.open()) {
         
            String sql = "DELETE FROM itemcarrito where id_carrito = :id_carrito";
            con.createQuery(sql)
                .addParameter("id_carrito", id_carrito)
                .executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);}

    }
    
}
