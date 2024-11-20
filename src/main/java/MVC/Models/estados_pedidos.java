package MVC.Models;

import lombok.Data;

@Data
public class estados_pedidos {
    private int id_estado;
    private String descripcion;

    // Getters y setters
    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}