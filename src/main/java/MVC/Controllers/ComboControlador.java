/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controllers;

import MVC.DAO.ComboDAO;
import MVC.DAO.PedidoDAO;
import MVC.DAO.ProductoDAO;
import MVC.Models.Combo;
import MVC.Models.Pedido;
import MVC.Models.Producto;
import Service.Isql2oDAO;
import Utils.Sql2oDAO;
import Velocity.VelocityTemplateEngine;
import java.util.HashMap;
import java.util.List;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author Tomas
 */
public class ComboControlador {
    
    public static Route viewCombos = (Request request, Response response) -> {
        HashMap model = new HashMap();
        Isql2oDAO sql2oDAO = new Sql2oDAO();
        ComboDAO bd = new ComboDAO(sql2oDAO);
        ProductoDAO pDAO = new ProductoDAO();
        List<Producto> productosbebida = pDAO.getProductosBebibles();
        List<Producto> productocomidas = pDAO.getProductosComestibles();
        
        System.out.println("entre viewCombos");
        model.put("template", "templates/verCombos.vsl");  // .vsl donde se va a mostrar 
        model.put("productobebida", productosbebida);
        model.put("productocomida", productocomidas);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout_backoffice.vsl"));
             
    };
    
    public static Route agregarCombo = (Request request, Response response) -> {
        HashMap model = new HashMap();
        Isql2oDAO sql2oDAO = new Sql2oDAO();
        ComboDAO comboDAO = new ComboDAO(sql2oDAO);

        Combo combo = new Combo();
        ProductoDAO pDAO = new ProductoDAO();
        List<Producto> productosbebida = pDAO.getProductosBebibles();
        List<Producto> productocomidas = pDAO.getProductosComestibles();
        Producto prod;
        //agrego el combo a la bd
        String nombreCombo = request.queryParams("nombreCombo");
        String selectBebida = request.queryParams("selectBebida");
        String cantBebida = request.queryParams("cantBebida");
        String selectComida = request.queryParams("selectComida");
        String cantComida = request.queryParams("cantComida");
        String descripcion = request.queryParams("descripcion");
        String precio = request.queryParams("precio");
        
        combo.setNombre(nombreCombo);
        System.out.println("ID bebida: "+selectBebida);
        System.out.println("ID bebida: "+pDAO.getProductoByNombre(selectBebida).getId());
        combo.setId_bebida(pDAO.getProductoByNombre(selectBebida).getId());
        combo.setCantBebida(Integer.parseInt(cantBebida));
        System.out.println("ID comida: "+selectComida);
        System.out.println("ID comestible: "+pDAO.getProductoByNombre(selectComida).getId());
        combo.setId_comida(pDAO.getProductoByNombre(selectComida).getId());
        combo.setCantComida(Integer.parseInt(cantComida));
        combo.setDescripcion(descripcion);
        combo.setPrecio(Integer.parseInt(precio));
        combo.setVisible("si");
        combo.setId_combo(0);
        
        comboDAO.cargarCombo(combo);
        
        model.put("template", "templates/verCombos.vsl");  // .vsl donde se va a mostrar 
        model.put("productobebida", productosbebida);
        model.put("productocomida", productocomidas);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout_backoffice.vsl"));
             
    };

    //Agregado

    public static Route verCombos = (Request request, Response response) ->{
        HashMap model = new HashMap();
        Isql2oDAO sql2oDAO = new Sql2oDAO();
        ComboDAO bdCombos = new ComboDAO(sql2oDAO);
        List<Combo> combos = bdCombos.getAllCombos();

        model.put("template", "templates/combos.vsl");  // .vsl donde se va a mostrar 
        model.put("combos", combos);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout_backoffice.vsl"));


    };




}
