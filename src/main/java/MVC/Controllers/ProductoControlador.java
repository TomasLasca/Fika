/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controllers;

import MVC.Models.Producto;
import MVC.DAO.ProductoDAO;
import Velocity.VelocityTemplateEngine;
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
public class ProductoControlador {
    
    public static Route productos = (Request request, Response response) -> {
        
        ProductoDAO bd = new ProductoDAO();
        List<Producto> prod = bd.obtenerProductos();

        HashMap model = new HashMap();
        model.put("template", "templates/productos.vsl");
        model.put("productos", prod);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
             
    };
    
    public static Route detalle = (Request request, Response response) -> {
        String id = request.queryParams("id");
        ProductoDAO bd = new ProductoDAO();
        HashMap model = new HashMap();
        List<Producto> prod = bd.obtenerProductoId(Integer.parseInt(id));
        model.put("producto", prod.get(0));
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/modal-producto.vsl"));
};
    
}
