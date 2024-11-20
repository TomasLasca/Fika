package MVC.DAO;

import java.util.ArrayList;
import java.util.List;

import org.sql2o.Connection;

import MVC.Models.estados_pedidos;
import Utils.Sql2oDAO;

public class estado_pedidosDAO {  
Sql2oDAO bd;  
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
}

