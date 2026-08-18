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

    
   public Espacios(int numeroEspacio, TipoEspacio tipo){
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

    public void setNumeroEspacio(int numeroEspacio) {
        this.numeroEspacio = numeroEspacio;
    }

    public void setTipo(TipoEspacio tipo) {
        this.tipo = tipo;
        cargarPrecioSegunTipo();
    } 
    
    public final void cargarPrecioSegunTipo() {
        this.tamaño = tipo.getTamaño();
        this.precioMensual = tipo.getPrecioMensual();
    }
    
    public void marcarOcupado(){
        this.disponible = false;
    }
    
    public void marcarDisponible() {
        this.disponible = true;
    }
    
    public boolean puedeEliminarse(){
        return disponible;
    }

    @Override
    public String toString() {
        return "Espacio #" + numeroEspacio + " - " + tipo +
                " (" + (disponible ? "Disponible" : "Ocupado") + ")";
    }
    
    
    
}
