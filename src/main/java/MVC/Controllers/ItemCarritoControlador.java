/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controllers;

import MVC.DAO.CarritoDAO;
import MVC.DAO.ItemCarritoDAO;
import MVC.Models.Carrito;
import MVC.Models.ItemCarrito;
import Utils.Sql2oDAO;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author Martin
 */
public class ItemCarritoControlador {
    public static Route detalle = (Request req, Response res) -> {
        
        ObjectMapper mapper = new ObjectMapper();
        int id = Integer.parseInt(req.queryParams("carrito_id"));
        ItemCarritoDAO bd = new ItemCarritoDAO(null);
        
        List<ItemCarrito> items = bd.obtenerItemsByCarritoId(id);
        
        String json = mapper.writeValueAsString(items);

        return json;
    };
    
        public static Route agregar = (Request req, Response res) -> {

        int carrito_id = Integer.parseInt(req.queryParams("carrito_id"));
        int producto_id = Integer.parseInt(req.queryParams("producto_id"));
        int cantidad = Integer.parseInt(req.queryParams("cantidad"));
        
        ItemCarrito new_item = new ItemCarrito();
        
        new_item.setId_carrito(carrito_id);
        new_item.setCantidad(cantidad);
        new_item.setId_producto(producto_id);
        
        ItemCarritoDAO bd = new ItemCarritoDAO(null);
        
        bd.cargarItemCarrito(new_item);
        
        res.status(201);

        return "Agregado";
    };
        
       public static Route actualizar = (Request req, Response res) -> {

        int carrito_id = Integer.parseInt(req.queryParams("carrito_id"));
        int producto_id = Integer.parseInt(req.queryParams("producto_id"));
        int cantidad = Integer.parseInt(req.queryParams("cantidad"));
        

        
        ItemCarritoDAO bd = new ItemCarritoDAO(null);
        
        bd.actualizarItemCarrito(carrito_id, producto_id, cantidad);
        
        res.status(200);

        return "Actualizado";
    };
}
