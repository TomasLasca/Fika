/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.fika;
import MVC.DAO.ProductoDAO;
import MVC.Models.Carrito;
import Velocity.VelocityTemplateEngine;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author Martin
 */
public class FikaController {
    private static Logger logger = LoggerFactory.getLogger(FikaController.class);
    
    public static Route inicio = (Request req, Response res)-> {
        logger.info("Pantalla de inicio..");
        HashMap model = new HashMap();

        model.put("template", "templates/home.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
    };
    
    public static Route login = (Request req, Response res)-> {
        HashMap model = new HashMap();
        logger.info("Pantalla de login...");
        model.put("template", "templates/login.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
    };
    
}
