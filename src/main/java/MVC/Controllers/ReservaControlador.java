/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controllers;

import MVC.Models.Reserva;
import MVC.DAO.ReservaDAO;
import Velocity.VelocityTemplateEngine;
import java.util.Date;
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
public class ReservaControlador {
    
    public static Route setReserva = (Request request, Response response) -> {
         
        Reserva reserva = new Reserva();
        ReservaDAO rDAO = new ReservaDAO();
        
        int a =4;
        
        reserva.setNro_reserva(a);
        reserva.setFecha_reserva(request.queryParams("fecha_reserva"));
        reserva.setSillas(Integer.parseInt(request.queryParams("sillas")));
        reserva.setNombre(request.queryParams("nombre"));
        reserva.setHora(request.queryParams("hora"));
        
        rDAO.realizar_reserva(reserva);
        
        HashMap model = new HashMap();
        model.put("template", "templates/reserva.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
             
    };
    
    
    
}
