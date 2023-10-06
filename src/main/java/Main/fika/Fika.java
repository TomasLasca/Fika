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
import com.google.gson.Gson;
import static spark.Spark.*;

/**
 *
 * @author Martin
 */
public class Fika {
    public static Gson gson = new Gson();
    public static void main(String[] args) {
        staticFiles.location("/assets");
        get("/", FikaController.inicio);
        get("/login", FikaController.login);
        get("/productos", ProductoControlador.productos);
        get("producto/detalle", ProductoControlador.detalle);
        get("/carrito", CarritoControlador.carrito);
        get("/carrito/detalle", CarritoControlador.detalle);
        get("/carrito/items", ItemCarritoControlador.detalle);
        post("/carrito/items/agregar", ItemCarritoControlador.agregar);
        post("/carrito/items/actualizar", ItemCarritoControlador.actualizar);
        post("/pedido/finalizar",PedidoControlador.finalizar);
        get("/reserva",MesaControlador.getMesas);
        get("/admin/pedidos",PedidoControlador.viewPedidos);
        get("/admin/combos",ComboControlador.viewCombos);
        post("/admin/pedidos/action",PedidoControlador.action);
        post("/admin/combos/agregar",ComboControlador.agregarCombo);
        post("/insertarres",ReservaControlador.setReserva); 
    }
}
//http://localhost:4567/
