/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controllers;

import MVC.DAO.CarritoDAO;
import MVC.DAO.ItemCarritoDAO;
import MVC.Models.Producto;
import Service.Isql2oDAO;
import Utils.Sql2oDAO;
import MVC.DAO.ProductoDAO;
import MVC.Models.Carrito;
import MVC.Models.Detalle;
import MVC.Models.ItemCarrito;
import Velocity.VelocityTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;


import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferencePaymentMethodRequest;
import com.mercadopago.client.preference.PreferencePaymentMethodsRequest;
import com.mercadopago.client.preference.PreferencePaymentTypeRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.resources.common.Address;
import com.mercadopago.resources.common.Identification;
import com.mercadopago.resources.common.Phone;
import com.mercadopago.resources.preference.Preference;
import com.mercadopago.resources.preference.PreferencePaymentMethod;
import java.math.BigDecimal;


/**
 *
 * @author Tomas
 */
public class CarritoControlador {
    
    public static Route crearPreferencia = (Request req, Response res) -> {
        MercadoPagoConfig.setAccessToken("TEST-4546216443926115-110409-61a3ac5fe6da930fa33b3357cd5b6a76-216697042");
        
       
        int total = Integer.parseInt(req.queryParams("total"));
        List<PreferenceItemRequest> items = new ArrayList<>();
        
        try {
            
            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
        .id("item-ID-1234")
        .title("Compra")
        .currencyId("ARG")
        .pictureUrl("https://www.mercadopago.com/org-img/MP3/home/logomp3.gif")
        .description("Fika avenida")
        .categoryId("Coffe")
        .quantity(1)
        .unitPrice(new BigDecimal(total))
        .build();
            
            //AGREGA ITEM, SOLO 1 
            items.add(itemRequest);
            

            PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                    .success("http://localhost:4567/")
                    .pending("http://localhost:4567/")
                    .failure("http://localhost:4567/")
                    .build();

            List<PreferencePaymentMethodRequest> excludedPaymentMethods = new ArrayList<>();
            
            List<PreferencePaymentTypeRequest> excludedPaymentTypes = new ArrayList<>();
            excludedPaymentTypes.add(PreferencePaymentTypeRequest.builder().id("credit_card").build());
            excludedPaymentTypes.add(PreferencePaymentTypeRequest.builder().id("debit_card").build());
            excludedPaymentTypes.add(PreferencePaymentTypeRequest.builder().id("cash").build());
           
            PreferencePaymentMethodsRequest paymentMethods = PreferencePaymentMethodsRequest.builder()
                    .excludedPaymentMethods(excludedPaymentMethods)
                    .excludedPaymentTypes(excludedPaymentTypes)
                    .installments(12)
                    .build();

            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    .backUrls(backUrls)
                    .externalReference("Fika")
                    .build();

            PreferenceClient client = new PreferenceClient();
            Preference preference = client.create(preferenceRequest);
            return preference.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al crear las preferencias";
        }
    };

    
    
    
    
    public static Route detalle = (Request req, Response res) -> {     
        ObjectMapper mapper = new ObjectMapper();
        int id = Integer.parseInt(req.queryParams("user_id"));
        CarritoDAO bd = new CarritoDAO();
        Carrito c = bd.getCarritoByUserId(id).get(0);
        String json = mapper.writeValueAsString(c);

        return json;
    };
    
        public static Route carrito = (Request req, Response res) -> {      
        Isql2oDAO sql2oDAO = new Sql2oDAO();
        int id = Integer.parseInt(req.queryParams("user_id"));
        HashMap model = new HashMap();
        CarritoDAO bd = new CarritoDAO();
        ItemCarritoDAO item_bd = new  ItemCarritoDAO(sql2oDAO);
        ProductoDAO productos_bd = new ProductoDAO();
        Carrito c = bd.getCarritoByUserId(id).get(0);
        
        ArrayList<Detalle> carrito = new ArrayList<>(0);
        
        List<ItemCarrito> items = item_bd.obtenerItemsByCarritoId(c.getId_carrito());
        double total = 0;
        for (ItemCarrito item: items) {
            int index = 0;
            Producto p = productos_bd.obtenerProductoId(item.getId_producto()).get(0);
            carrito.add(new Detalle(p, item.getCantidad()));
            total = total + carrito.get(index).getTotal();
        }
                
        model.put("template", "templates/carrito.vsl");
        model.put("total", total);
        model.put("itemCarrito", carrito);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
    };
    
    

    public static Route agregar = (Request req, Response res) -> {
        ObjectMapper mapper = new ObjectMapper();
        Carrito carrito = new Carrito();
        ProductoDAO bd = new ProductoDAO();
        String producto_id = req.queryParams("producto_id");
        String cantidad = req.queryParams("cantidad");
        List<Producto> prod = bd.obtenerProductoId(Integer.parseInt(producto_id));

        /*ItemCarrito resp = carrito.addItem(prod.get(0), Integer.parseInt(cantidad));*/

        String json = mapper.writeValueAsString(1);

        return json;

    };
    
    
    
}
