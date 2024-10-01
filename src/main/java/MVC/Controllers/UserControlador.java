/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controllers;

import MVC.DAO.UserDAO;
import MVC.Models.User;
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
 * @author USUARIO
 */
public class UserControlador {
    
        public static Route 
        getLogin = (Request req, Response res) -> {
            
                HashMap model = new HashMap();
                
                String email = req.queryParams("email");
                String pass = req.queryParams("pass");
                
                
                
                if(email!=null && pass!=null){
                    
                    UserDAO userDao = new UserDAO();
                    List<User> user = userDao.verificarPersona(email,pass);
                    
                    
                    if (user == null) {
                        model.put("template", "templates/login.vsl");
                        model.put("request",req);
                        model.put("error", "La contraseña o el email es incorrecto.");
                    }
                    
                    if(user.size() > 0){
                        model.put("template", "templates/login.vsl");
                        User usuarioLogeado = user.get(0);    //dudas
                        req.session(true);                     // Crear y retornar la sesion
                        req.session().attribute("id_usuario", usuarioLogeado.getId_usuario() );       // Seteamos atributo
                        req.session().attribute("email", usuarioLogeado.getEmail() ); // Seteamos atributo
                        
                        System.out.println("email: "+usuarioLogeado.getEmail());
                        System.out.println("tipo: "+usuarioLogeado.getTipo_usuario());
                        String Tipo_u = usuarioLogeado.getTipo_usuario();
                        
                        
                        
                        if(Tipo_u.equals("administrador")){
                            System.out.println("entro a modo administrador");
                            res.redirect("/admin/pedidos");  //lleva al admi a ver pedidos
                            
                        }else{
                            System.out.println("entro a modo cliente");
                            res.redirect("/productos");  //lleva al inicio de compra si no es adminitrador
                        }
                        
                        
                    }
                    
                }else{
                    model.put("email","");
                    model.put("template", "templates/login.vsl");
                }
                
                return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));   
            
        };    
            
            
            
            
            
            
           
          
    
    public static Route 
            getLogout = (Request req, Response res) -> {
     
            req.session().attribute("iq_usuario");
            req.session().attribute("email");
            res.redirect("/home");
            return null;
        };
    
    
    
    
    
    
    
}
