package MVC.DAO;

import java.util.ArrayList;
import java.util.List;

import org.sql2o.Connection;

import MVC.Models.estados_pedidos;
import Service.Isql2oDAO;
import Utils.Sql2oDAO;

public class estado_pedidosDAO {  
       private final Isql2oDAO bd; // Referencia a la interfaz
    
    public estado_pedidosDAO(Isql2oDAO sql2oDAO) {
        this.bd = sql2oDAO; // Inyección de dependencia
    }
public List<estados_pedidos> getEstadosPedidosExcepto(String descripcionExcluida) {
    List<estados_pedidos> estados = new ArrayList<>();
    try (Connection con = bd.getSql2o().open()) {
        String sql = "SELECT * FROM estados_pedidos WHERE descripcion != :descripcionExcluida";
        estados = con.createQuery(sql)
            .addParameter("descripcionExcluida", descripcionExcluida)
            .executeAndFetch(estados_pedidos.class); // Mapea los resultados a la clase EstadoPedido
    } catch (Exception e) {
        e.printStackTrace();
    }
    return estados;
    }

    public List<estados_pedidos> getEstados() {
        List<estados_pedidos> estados = new ArrayList<>();
        try (Connection con = bd.getSql2o().open()) {
            String sql = "SELECT * FROM estados_pedidos";
            estados = con.createQuery(sql)
                .executeAndFetch(estados_pedidos.class); // Mapea los resultados a la clase EstadoPedido
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estados;
    }

}

