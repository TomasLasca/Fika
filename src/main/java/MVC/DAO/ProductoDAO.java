/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.DAO;

import MVC.Models.Producto;
import Main.fika.Fika;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Tomas
 */
public class ProductoDAO {
    
    private static Logger logger = LoggerFactory.getLogger(ProductoDAO.class);
    
    private List<Producto> productos;


    public List<Producto> obtenerProductos() {

        //colocar los datos de su  servidor de Mysql (root) y contrasea (adminadmin)
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "root", "");

        try (Connection con = sql2o.open()) {
           
            String sql = "SELECT * FROM productos";

            productos = con
                .createQuery(sql)
                .executeAndFetch(Producto.class);
            logger.info("Se cargaron todos los productos");
        }
        catch(Exception e) {
            logger.error("No se pudieron cargar todos los productos");
        }
        

        return productos;
    }
    
    public List<Producto> obtenerProductoId(int id) {
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "root", "");
     
        try (Connection con = sql2o.open()) {
           
            String sql = "SELECT * FROM productos WHERE id = :id";

            productos = con
                .createQuery(sql)
                .addParameter("id", id)
                .executeAndFetch(Producto.class);
        }
        catch(Exception e) {
            System.out.println(e);}
        
        return productos;
    }
    
    
    public List<Producto> getProductosComestibles() {
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "root", "");
     
        try (Connection con = sql2o.open()) {
           
            String sql = "SELECT * FROM productos WHERE categoria='comida'";

            productos = con
                .createQuery(sql)
                .executeAndFetch(Producto.class);
        }
        catch(Exception e) {
            System.out.println(e);}
        
        return productos;
    }
    
    public List<String> getNombresProductosComestibles(){
        
        List<String> lista = new ArrayList<>();
        List<Producto> listaProductos = getProductosComestibles();
        for (Producto producto : listaProductos) {
            lista.add(producto.getNombre());
        }
        
        return lista;
    }
    
    public List<String> getNombresProductosBebibles(){
        
        List<String> lista = new ArrayList<>();
        List<Producto> listaProductos = getProductosBebibles();
        for (Producto producto : listaProductos) {
            lista.add(producto.getNombre());
        }
        return lista;
    }
    
     public List<Producto> getProductosBebibles() {
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "root", "");
     
        try (Connection con = sql2o.open()) {
           
            String sql = "SELECT * FROM productos WHERE categoria='bebidas'";

            productos = con
                .createQuery(sql)
                .executeAndFetch(Producto.class);
        }
        catch(Exception e) {
            System.out.println(e);}
        
        return productos;
    }
     
    /**
     *
     * @param nombre
     * @return
     */
    public Producto getProductoByNombre(String nombre){
            Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/fikabd", "root", "");
            
        try (Connection con = sql2o.open()) {
           
            String sql = "SELECT * FROM productos WHERE nombre like :nombre";

           productos = con.createQuery(sql)
                     .addParameter("nombre", nombre)
                     .executeAndFetch(Producto.class);
        }
        catch(Exception e) {
            System.out.println(e);}
        
        return productos.get(0);
     }
    
    
}
