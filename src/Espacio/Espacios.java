/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Espacio;

/**
 *
 * @author Usuario
 */
public class Espacios {
    private int numeroEspacio;
    private TipoEspacio tipo;
    private double tamaño;
    private double precioMensual;
    private boolean disponible;

    
    public Espacios(int numeroEspacio, TipoEspacio tipo) {
        if (numeroEspacio <= 0 || tipo == null) {
            throw new IllegalArgumentException("Datos del espacio incorrectos.");
        }
        this.numeroEspacio = numeroEspacio;
        this.tipo = tipo;
        cargarPrecioSegunTipo();
        this.disponible = true;
    }
    
    public int getNumeroEspacio() {
        return numeroEspacio;
    }

    public TipoEspacio getTipo() {
        return tipo;
    }

    public double getTamaño() {
        return tamaño;
    }

    public double getPrecioMensual() {
        return precioMensual;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setTipo(TipoEspacio tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("Debe seleccionar un tipo de espacio.");
        }
        this.tipo = tipo;
        cargarPrecioSegunTipo();
    }

    public void setTamaño(double tamaño) {
        if (tamaño <= 0) {
            throw new IllegalArgumentException("El tamaño debe ser mayor que cero.");
        }
        this.tamaño = tamaño;
    }

    public void setPrecioMensual(double precioMensual) {
        if (precioMensual <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }
        this.precioMensual = precioMensual;
    }
    
    public final void cargarPrecioSegunTipo() {
        this.tamaño = tipo.getTamaño();
        this.precioMensual = tipo.getPrecioMensual();
    }

    public void marcarOcupado() {
        this.disponible = false;
    }
    
    public void marcarDisponible() {
        this.disponible = true;
    }
    
    public boolean puedeEliminarse() {
        return disponible;
    }

    @Override
    public String toString() {
        return "Espacio #" + numeroEspacio + " - " + tipo +
                " (" + (disponible ? "Disponible" : "Ocupado") + ")";
    }
    
    
    
}
