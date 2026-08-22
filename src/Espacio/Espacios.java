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
    private final int numeroEspacio;
    private TipoEspacio tipo;
    private double tamaño;
    private double precioMensual;
    private boolean disponible;

    
   public Espacios(int numeroEspacio, TipoEspacio tipo){
        validarNumeroEspacio(numeroEspacio);
        validarTipo(tipo);

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
        validarTipo(tipo);
        this.tipo = tipo;
        cargarPrecioSegunTipo();
    }

    public void setTamaño(double tamaño) {
        validarValorPositivo(tamaño, "El tamaño");
        this.tamaño = tamaño;
    }

    public void setPrecioMensual(double precioMensual) {
        validarValorPositivo(precioMensual, "El precio mensual");
        this.precioMensual = precioMensual;
    }
    
    public final void cargarPrecioSegunTipo() {
        this.tamaño = tipo.getTamaño();
        this.precioMensual = tipo.getPrecioMensual();
    }

    private static void validarNumeroEspacio(int numeroEspacio) {
        if (numeroEspacio <= 0) {
            throw new IllegalArgumentException("El número de espacio debe ser mayor que cero.");
        }
    }

    private static void validarTipo(TipoEspacio tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de espacio es obligatorio.");
        }
    }

    private static void validarValorPositivo(double valor, String nombreCampo) {
        if (Double.isNaN(valor) || Double.isInfinite(valor) || valor <= 0) {
            throw new IllegalArgumentException(nombreCampo + " debe ser mayor que cero.");
        }
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
