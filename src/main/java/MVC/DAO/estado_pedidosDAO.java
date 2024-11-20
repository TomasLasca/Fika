package MVC.DAO;

import java.util.ArrayList;
import java.util.List;


import MVC.Models.Pedido;
import Utils.Sql2oDAO;
import static Utils.Sql2oDAO.getSql2o;
import java.sql.SQLException;
import java.util.List;
import org.sql2o.Connection;

import Utils.Sql2oDAO;

import MVC.Models.estados_pedidos;

public class estado_pedidosDAO {

    Sql2oDAO bd;

    public List<estados_pedidos> getEstadosPedidosExcepto(String descripcionExcluida) {
    List<estados_pedidos> estados = new ArrayList<>();
    try (Connection con = Sql2oDAO.getSql2o().open()) {
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
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            String sql = "SELECT * FROM estados_pedidos";
            estados = con.createQuery(sql)
                .executeAndFetch(estados_pedidos.class); // Mapea los resultados a la clase EstadoPedido
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estados;
    }

}
