/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;

import MVC.Models.DetallePedido;
import MVC.Models.ItemCarrito;
import Service.Isql2oDAO;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Martin
 */
public class DetallePedidoDAO {
    private final Isql2oDAO bd; // Referencia a la interfaz
    
    public DetallePedidoDAO(Isql2oDAO sql2oDAO) {
        this.bd = sql2oDAO; // Inyección de dependencia
    }
        public void cargarDetalle(DetallePedido detalle){
       
        
        try (Connection con = bd.getSql2o().open()) {
           
            String sql = "INSERT INTO detallepedido VALUES(:nro_pedido, :id_producto, :cantidad_producto )";
            con.createQuery(sql)
                .bind(detalle)
                .executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);}
    }
}
