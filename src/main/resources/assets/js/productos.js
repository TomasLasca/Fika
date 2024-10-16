function hola(id) {
    $('#modal-detail').empty();
    $.ajax({
        type: 'GET',
        url: 'producto/detalle?id='+id,
        success: (result, status) => {
            $('#modal-detail').append(result);
            $('#modal-producto').modal('show');
            
            let resta = document.getElementsByClassName('resta');
            let suma = document.getElementsByClassName('suma');
        
            for (let i = 0; i < resta.length; i++ ) {
                let boton_resta = resta[i];
                let boton_suma = suma[i];
        
                boton_resta.addEventListener('click', (e)=> {
                    let boton_resta_clickeado = event.target;
                    let contador = boton_resta_clickeado.parentElement.children[1];
                    if (contador.innerHTML>1) {
                        contador.innerHTML--;
                    }
                });
        
                boton_suma.addEventListener('click', (e)=> {
                    let boton_suma_clickeado = event.target;
                    let contador = boton_suma_clickeado.parentElement.children[1];
                        contador.innerHTML++;
                });
                
            }
            
        },
        error: (xhr, status, err) => {

        }
    });
}

function getCarritoId(user_id) {
            $.ajax({
        type: 'GET',
        url: 'carrito/detalle?user_id='+user_id,
        success: (result, status) => {
            let element = JSON.parse(result);
            let carrito_id = element.id_carrito;
            
        },
        error: (xhr, status, err) => {

        }
    });
    
    return carrito_id;
}


function finalizarPedido(user_id){

    
    const pago_id = $('#pago').val();
    const fecha = $('#fecha').val();
    const hora = $('#hora').val();    
    
    $.ajax({
        type: 'POST',
        url: 'pedido/finalizar',
        data: { user_id: user_id, pago_id: pago_id, fecha: fecha, hora: hora},
        success: (result, status) => {
            $('#carrito-usuario').empty();
            $('#carrito-usuario').html(result);
        },
        error: (xhr, status, err) => {

        }
    });
}

function searchItem(id_carrito, producto_id, cant){
        let find = false;
        $.ajax({
        type: 'GET',
        url: 'carrito/items?carrito_id='+id_carrito,
        success: (result, status) => {
            let array = JSON.parse(result);
            array.forEach(element => {
			if(element.id_producto === producto_id) {
                            cant = cant + Number(element.cantidad);
                            $.post('carrito/items/actualizar?carrito_id='+id_carrito+'&producto_id='+producto_id+'&cantidad='+cant);
                            find = true;
                        }
		});
                if (!find){
                    $.post('carrito/items/agregar?carrito_id='+id_carrito+'&producto_id='+producto_id+'&cantidad='+cant);
                }
                window.location.href = "http://localhost:4567/carrito?user_id=0";
        },
        error: (xhr, status, err) => {

        }
    });
}

function agregarCarrito(producto_id) {
    // Este valor depende del login //
    let user_id = 0;
    let cant = Number(document.getElementById('cantidad').innerHTML);
    
    $.ajax({
        type: 'GET',
        url: 'carrito/detalle?user_id='+user_id,
        success: (result, status) => {
            let element = JSON.parse(result);
            searchItem(element.id_carrito, producto_id, cant);
        },
        error: (xhr, status, err) => {

        }
    });
    /* let new_item = { id: producto_id, cantidad: Number(cant) }

    let item = JSON.parse(localStorage.getItem('item'));
    let find = false;
    if (item) {
        item.forEach((producto) => {
            if (producto.id == new_item.id) {
                producto.cantidad += new_item.cantidad;
                find = true;
            }
        });
        if (!find) {
            item.push(new_item);
        }
        localStorage.setItem('item', JSON.stringify(item));
    } else {
        item = [];
        item.push(new_item);
        localStorage.setItem('item', JSON.stringify(item));
    }
    document.cookie = "item=" + JSON.stringify(item);
    $('#modal-producto').modal('hide');
    $(location).prop('href', '/carrito')
     */
}


function accionPedido(accion,pedido_id) {
    // Este valor depende del login //
    console.log("ENTREE");
    /*
    $.ajax({
        type: 'POST',
        url: 'admin/pedidos/action?pedido_id='+pedido_id+"&accion="+accion,
        success: (result, status) => {
            let element = JSON.parse(result);
            searchItem(element.id_carrito, producto_id, cant);
            console.log("Sali");
        },
        error: (xhr, status, err) => {

        }
    });
     
     */
}
