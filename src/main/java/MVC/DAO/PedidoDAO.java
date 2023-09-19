/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;

import MVC.Models.Pedido;
import Utils.Sql2oDAO;
import static Utils.Sql2oDAO.getSql2o;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Tomas
 */
public class PedidoDAO {
     private List<Pedido> pedidos;

    public void cargarPedido(Pedido pedido){
            Sql2o bd;
        bd = getSql2o();
        
        try (Connection con = bd.open()) {
           
            String sql = "INSERT INTO pedidos VALUES(:nro_pedido, :id_estado, :id_usuario , :fecha_pedido, :hora_pedido, :id_metodo)";
            con.createQuery(sql)
                .bind(pedido)
                .executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);}
    }
    
    public List <Pedido> verPedidos(){
                    Sql2o bd;
        bd = getSql2o();
        
        try (Connection con = bd.open()) {
           
            String sql = "SELECT * FROM pedidos";
            pedidos = con
                .createQuery(sql)
                .executeAndFetch(Pedido.class);
        }
        catch(Exception e) {
            System.out.println(e);}
      return pedidos;
    }
    
    public List<Pedido> ultimoIndex() {
        Sql2o bd;
        bd = getSql2o();
        
        try (Connection con = bd.open()) {
           
            String sql = "SELECT * FROM pedidos WHERE nro_pedido = (SELECT MAX(nro_pedido) FROM pedidos)";
            pedidos = con
                .createQuery(sql)
                .executeAndFetch(Pedido.class);
        }
        catch(Exception e) {
            System.out.println(e);}
      return pedidos;
    }
      
        
 }

       