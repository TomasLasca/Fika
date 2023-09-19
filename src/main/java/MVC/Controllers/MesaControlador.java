/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controllers;

import MVC.DAO.MesaDAO;
import MVC.Models.Mesa;
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
public class MesaControlador {
    public static Route getMesas = (Request request, Response response) -> {
        
        MesaDAO eDAO = new MesaDAO(); 
        List<Mesa> me = eDAO.obtenerMesas();
        System.out.println(me);
        HashMap model = new HashMap();
        model.put("template", "templates/reserva.vsl");
        model.put("mesas", me);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
        
       
    };
}
