/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;

import MVC.Models.DetallePedido;
import MVC.Models.ItemCarrito;
import static Utils.Sql2oDAO.getSql2o;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Martin
 */
public class DetallePedidoDAO {
        public void cargarDetalle(DetallePedido detalle){
        Sql2o bd;
        bd = getSql2o();
        
        try (Connection con = bd.open()) {
           
            String sql = "INSERT INTO detallepedido VALUES(:nro_pedido, :id_producto, :cantidad_producto )";
            con.createQuery(sql)
                .bind(detalle)
                .executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);}
    }
}
