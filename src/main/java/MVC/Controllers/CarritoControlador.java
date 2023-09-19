/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controllers;

import MVC.DAO.CarritoDAO;
import MVC.DAO.ItemCarritoDAO;
import MVC.Models.Producto;
import MVC.DAO.ProductoDAO;
import MVC.Models.Carrito;
import MVC.Models.Detalle;
import MVC.Models.ItemCarrito;
import Velocity.VelocityTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author Tomas
 */
public class CarritoControlador {
    public static Route detalle = (Request req, Response res) -> {
        /*String json_item = req.cookie("item");
        ProductoDAO bd = new ProductoDAO();
        Carrito c = new Carrito();*/
                /*if (json_item != null) {
            TempItem[] items = Fika.gson.fromJson(json_item, TempItem[].class);
            for(TempItem item: items) {
                int producto_id = Integer.parseInt(item.getId());
                int cantidad_producto = Integer.parseInt(item.getCantidad());
                List<Producto> producto = bd.obtenerProductoId(producto_id);
                c.addItem(producto.get(0), cantidad_producto);
            }
        }*/
        ObjectMapper mapper = new ObjectMapper();
        int id = Integer.parseInt(req.queryParams("user_id"));
        CarritoDAO bd = new CarritoDAO();
        Carrito c = bd.getCarritoByUserId(id).get(0);
        String json = mapper.writeValueAsString(c);

        return json;
    };
    
        public static Route carrito = (Request req, Response res) -> {
        /*String json_item = req.cookie("item");
        ProductoDAO bd = new ProductoDAO();
        Carrito c = new Carrito();*/
                /*if (json_item != null) {
            TempItem[] items = Fika.gson.fromJson(json_item, TempItem[].class);
            for(TempItem item: items) {
                int producto_id = Integer.parseInt(item.getId());
                int cantidad_producto = Integer.parseInt(item.getCantidad());
                List<Producto> producto = bd.obtenerProductoId(producto_id);
                c.addItem(producto.get(0), cantidad_producto);
            }
        }*/
        
        int id = Integer.parseInt(req.queryParams("user_id"));
        HashMap model = new HashMap();
        CarritoDAO bd = new CarritoDAO();
        ItemCarritoDAO item_bd = new  ItemCarritoDAO();
        ProductoDAO productos_bd = new ProductoDAO();
        Carrito c = bd.getCarritoByUserId(id).get(0);
        
        ArrayList<Detalle> carrito = new ArrayList<>(0);
        
        List<ItemCarrito> items = item_bd.obtenerItemsByCarritoId(c.getId_carrito());
        double total = 0;
        for (ItemCarrito item: items) {
            int index = 0;
            Producto p = productos_bd.obtenerProductoId(item.getId_producto()).get(0);
            carrito.add(new Detalle(p, item.getCantidad()));
            total = total + carrito.get(index).getTotal();
        }
                
        model.put("template", "templates/carrito.vsl");
        model.put("total", total);
        model.put("itemCarrito", carrito);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
    };
    
    

    public static Route agregar = (Request req, Response res) -> {
        ObjectMapper mapper = new ObjectMapper();
        Carrito carrito = new Carrito();
        ProductoDAO bd = new ProductoDAO();
        String producto_id = req.queryParams("producto_id");
        String cantidad = req.queryParams("cantidad");
        List<Producto> prod = bd.obtenerProductoId(Integer.parseInt(producto_id));

        /*ItemCarrito resp = carrito.addItem(prod.get(0), Integer.parseInt(cantidad));*/

        String json = mapper.writeValueAsString(1);

        return json;

    };
    
}
