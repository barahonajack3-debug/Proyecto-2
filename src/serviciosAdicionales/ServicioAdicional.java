/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviciosAdicionales;

/**
 *
 * @author EMMAXZZ
 */
public class ServicioAdicional {
private static int contador = 1;
private int codigo;
private String nombre;
private String descripcion;
private double precio; 

        
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public ServicioAdicional( String nombre, String descripcion, double precio) {
        this.codigo = contador;
        contador++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }


}
