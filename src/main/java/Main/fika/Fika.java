/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Main.fika;

import MVC.Controllers.CarritoControlador;
import MVC.Controllers.ComboControlador;
import MVC.Controllers.ItemCarritoControlador;
import MVC.Controllers.MesaControlador;
import MVC.Controllers.PedidoControlador;
import MVC.Controllers.ProductoControlador;
import MVC.Controllers.ReservaControlador;
import MVC.Controllers.UserControlador;

import static spark.Spark.*;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Martin
 */
public class Fika {
    
    private static Logger logger = LoggerFactory.getLogger(Fika.class);
    
    public static Gson gson = new Gson();
    public static void main(String[] args) {
        staticFiles.location("/assets");
        get("/", FikaController.inicio);
        get("/login", FikaController.login);
        
        //
        get("/getLogin",UserControlador.getLogin);
        post("/getLogin",UserControlador.getLogin);
        //
        get("/productos", ProductoControlador.productos);
        get("producto/detalle", ProductoControlador.detalle);
        get("/carrito", CarritoControlador.carrito);
        get("/carrito/detalle", CarritoControlador.detalle);
        get("/carrito/items", ItemCarritoControlador.detalle);
        post("/carrito/items/agregar", ItemCarritoControlador.agregar);
        post("/carrito/items/actualizar", ItemCarritoControlador.actualizar);
        get("carrito/crearPreferencia",CarritoControlador.crearPreferencia);
        post("/pedido/finalizar",PedidoControlador.finalizar);
        get("/reserva",MesaControlador.getMesas);
        get("/admin/pedidos",PedidoControlador.viewPedidos);
        get("/admin/combos",ComboControlador.viewCombos);
        get("/admin/pedidos/cambioEstado",PedidoControlador.cambioEstado);
        post("/admin/combos/agregar",ComboControlador.agregarCombo);
        post("/insertarres",ReservaControlador.setReserva); 
    }
}
//http://localhost:4567/
