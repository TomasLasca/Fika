/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controllers;

import MVC.DAO.CarritoDAO;
import MVC.DAO.DetallePedidoDAO;
import MVC.DAO.ItemCarritoDAO;
import MVC.Models.Pedido;
import MVC.DAO.PedidoDAO;
import MVC.Models.Carrito;
import MVC.Models.Detalle;
import MVC.Models.DetallePedido;
import MVC.Models.ItemCarrito;
import MVC.Models.Producto;
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
 * @author Fikaneta
 */
public class PedidoControlador {
        
        public static Route finalizar = (Request request, Response response) -> {
        
        PedidoDAO bd = new  PedidoDAO();
        CarritoDAO carrito_bd = new CarritoDAO();
        ItemCarritoDAO item_bd = new ItemCarritoDAO();
        DetallePedidoDAO detalle_bd = new DetallePedidoDAO();
        int user_id = Integer.parseInt(request.queryParams("user_id"));
        int pago_id = Integer.parseInt(request.queryParams("pago_id"));
        String fecha = request.queryParams("fecha");
        String hora = request.queryParams("hora");
        
        // Simula pago si el pago es aprobado el estado es pendiente, en caso contrario seria rechazado
        String estado_id = "pendiente"; // Pendiente
        
        Pedido p = new Pedido();
        p.setId_usuario(user_id);
        p.setEstado(estado_id);
        p.setId_metodo(pago_id);
        p.setHora_pedido(hora);
        p.setFecha_pedido(fecha);

        bd.cargarPedido(p);
        p = bd.ultimoIndex().get(0);
        Carrito carrito_usuario = carrito_bd.getCarritoByUserId(user_id).get(0);
        int nro_pedido = p.getNro_pedido();
        int id_carrito = carrito_usuario.getId_carrito();
        // Mudar carrito del usuario a detalle del pedido
        List<ItemCarrito> items = item_bd.obtenerItemsByCarritoId(id_carrito);
        
        for (ItemCarrito item: items) {
            DetallePedido detalle = new DetallePedido();
            
            detalle.setId_producto(item.getId_producto());
            detalle.setNro_pedido(nro_pedido);
            detalle.setCantidad_producto(item.getCantidad());
            
            detalle_bd.cargarDetalle(detalle);
        }
        // Limpia el carrito del usuario
        item_bd.clearItemCarrito(carrito_usuario.getId_carrito());
        
        HashMap model = new HashMap();
        model.put("pedido", p);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/pedido_finalizado.vsl"));
             
    };
        
        public static Route viewPedidos = (Request request, Response response) -> {
        HashMap model = new HashMap();
        PedidoDAO bd = new  PedidoDAO();
        List<Pedido> pedidos = bd.verPedidos();
        
        model.put("template", "templates/verPedidos.vsl");  // .vsl donde se va a mostrar 
        model.put("pedidos", pedidos);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout_backoffice.vsl"));
             
    };
        
        public static Route action = (Request request, Response response) -> {
            PedidoDAO pedidoDAO = new PedidoDAO(); 
            Pedido pedido = new Pedido();
            String nuevoEstado;
            boolean band = false;
            boolean res = false;
            int id_pedido = Integer.parseInt(request.queryParams("pedido_id"));
            String accion = request.queryParams("accion");
            /*if(accion.equals("eliminar")){
                    System.out.println("eliminando pedido");
                    pedidoDAO.CambioEstadoPedido(2,id_pedido);
                    band=true;
            }else{
                pedido = pedidoDAO.getEstadoByNroPedido(id_pedido);
                nuevoEstado = pedido.getId_estado();
                System.out.println("estado a cambiar: " + String.valueOf(nuevoEstado));
                if(accion.equals("siguiente")){
                    if(nuevoEstado != "pendiente"){
                        if(nuevoEstado+1 == 2)
                            nuevoEstado++;
                        res=pedidoDAO.CambioEstadoPedido(nuevoEstado+1,id_pedido);
                        System.out.println("se cambio a: " + String.valueOf(nuevoEstado+1));
                        band= true;
                    }
                }else{
                    if(nuevoEstado != 1){
                        if(nuevoEstado==3)
                            nuevoEstado--;
                        res=pedidoDAO.CambioEstadoPedido(nuevoEstado-1,id_pedido);
                        System.out.println("se cambio a: " + String.valueOf(nuevoEstado+1));
                        band= true;
                    }
                }
            }*/
            
        
        return 1;     
        };
        
}
