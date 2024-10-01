/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;
import MVC.Models.User;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
/**
 *
 * @author USUARIO
 */
public class UserDAO {
    private List<User> usuarios;
    
    public List<User> verificarPersona( String email, String pass) {
        
        //colocar los datos de su  servidor de Mysql (root) y contrasea (" ")
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "root", "");
         
        try (Connection con = sql2o.open()) {
            
            String sql = "SELECT * FROM usuarios WHERE email = :email and  pass = :pass";

            usuarios = con
                .createQuery(sql)
                .addParameter("email", email)
                .addParameter("pass", pass)
     
                .executeAndFetch(User.class);
        }
        catch(Exception e) {
            System.out.println(e);}
        return usuarios;
    
    }
    
    
    // no se usa lo deje por las dudas
    public User getUserByUsername(String email) {
        
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/loginspark?serverTimezone=UTC", "root", "");

        
        User user;
        try (Connection connection = sql2o.open()) {
            user = connection
                    .createQueryWithParams("SELECT * FROM usuarios WHERE (email = :u)")
                    .addParameter("u", email)
                    .executeAndFetch(User.class)
                    .get(0);

            return user;
        } catch (Exception e) {
            return null;
        }
    }    
    
    
    
    
    
    
    
    
}
