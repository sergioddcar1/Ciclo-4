package co.edu.unab.api_rest_articulo.models;

import org.springframework.data.annotation.Id;

public class ArticuloModel {
    @Id
    private String id;
    private String categoria;
    private String nombre;
    private String descripcion;
    private Long precio;
    private boolean disponibilidad;
    private int cantidad;

    
    public ArticuloModel() {
    }


    public ArticuloModel(String id, String categoria, String nombre, String descripcion, Long precio,
            boolean disponibilidad, int cantidad) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.cantidad = cantidad;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getCategoria() {
        return categoria;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Long getPrecio() {
        return precio;
    }


    public void setPrecio(Long precio) {
        this.precio = precio;
    }


    public boolean isDisponibilidad() {
        return disponibilidad;
    }


    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
