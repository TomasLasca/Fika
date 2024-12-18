/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;

import MVC.Models.Pedido;
import Service.Isql2oDAO;
import java.util.Arrays;
import java.util.List;
import Utils.Util;
import org.sql2o.Connection;

public class PedidoDAO {
     private List<Pedido> pedidos;
    private final Isql2oDAO bd; // Referencia a la interfaz
    
    public PedidoDAO(Isql2oDAO sql2oDAO) {
        this.bd = sql2oDAO; // Inyección de dependencia
    }

    public void cargarPedido(Pedido pedido){
        pedido.setEstado("en preparacion");
        try (Connection con = bd.getSql2o().open()) {
           
            String sql = "INSERT INTO pedidos VALUES(:nro_pedido, :id_estado, :id_usuario , :fecha_pedido, :hora_pedido, :id_metodo)";
            con.createQuery(sql)
                .bind(pedido)
                .executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);}
    }
    
    public List <Pedido> verPedidos(){
        
        try (Connection con = bd.getSql2o().open()) {
           
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
        
        try (Connection con = bd.getSql2o().open()) {
           
            String sql = "SELECT * FROM pedidos WHERE nro_pedido = (SELECT MAX(nro_pedido) FROM pedidos)";
            pedidos = con
                .createQuery(sql)
                .executeAndFetch(Pedido.class);
        }
        catch(Exception e) {
            System.out.println(e);}
      return pedidos;
    }
    
    public boolean eliminarPedido(int id) {
    boolean band = false;
        try (Connection con = bd.getSql2o().open()) {      

           String sqlDetalle = "DELETE FROM detallepedido WHERE nro_pedido = :id";
        con.createQuery(sqlDetalle)
            .addParameter("id", id)
            .executeUpdate();

        // Luego, elimina el pedido principal
        String sqlPedido = "DELETE FROM pedidos WHERE nro_pedido = :id";
        int rowCount = con.createQuery(sqlPedido)
            .addParameter("id", id)
            .executeUpdate().getResult();

        // Si se eliminaron registros en ambas tablas, confirma la transacción
        if (rowCount > 0) {
            con.commit();
            band = true;
        } else {
            con.rollback(); // Si no se eliminaron registros, haz un rollback
        }
        }catch(Exception e) {
            System.out.println(e);
        }
    return band;
    }
    
   public Pedido getPedido(int nro) {
    Pedido estado = null;
    try (Connection con = bd.getSql2o().open()) {
        String sql = "SELECT * FROM pedidos WHERE nro_pedido = :nro";
        estado = con.createQuery(sql)
            .addParameter("nro", nro)
            .executeAndFetchFirst(Pedido.class);
    } catch (Exception e) {
        e.printStackTrace();
        return estado; // Error: sentencia 'return' inalcanzable
    }
    return estado;
    }    
    public boolean CambioEstadoPedido(String nuevoEstado,int id) {
        boolean band=false;
        try (Connection con = bd.getSql2o().open()) {                
                Pedido pedido = getPedido(id);
                List<String> fieldsToUpdate = Arrays.asList("estado");
                pedido.setEstado(nuevoEstado);                
                Util.updateEntity(con, pedido, "pedidos", "nro_pedido", pedido.getNro_pedido(),fieldsToUpdate);                         
            
        }
        catch(Exception e) {
            System.out.println(e);}
      return band;
    }
      
        
 }

       