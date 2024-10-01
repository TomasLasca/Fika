/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;

import MVC.Models.Carrito;
import MVC.Models.Usuario;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Tomas
 */
public class UsuarioDAO {
    
    private List<Usuario> usuarios;
    
    public List<Usuario> getAllUsuarios() {

        //colocar los datos de su  servidor de Mysql (root) y contrasea (adminadmin)
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "agus", "a");

        try (Connection con = sql2o.open()) {
           
            String sql = "SELECT * FROM Usuario";

            usuarios = con
                .createQuery(sql)
                .executeAndFetch(Usuario.class);
        }
        catch(Exception e) {
            System.out.println(e);}
        

        return usuarios;
    }
    
    
    
}
