/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Espacio;

/**
 *
 * @author Usuario
 */
public enum TipoEspacio {
    PEQUEÑO(5,25000),
    MEDIANO(10,45000),
    GRANDE(20,70000);
    
    private final double tamaño;
    private final double precioMensual;

    public double getTamaño() {
        return tamaño;
    }

    public double getPrecioMensual() {
        return precioMensual;
    }

    private TipoEspacio(double tamaño, double precioMensual) {
        this.tamaño = tamaño;
        this.precioMensual = precioMensual;
    }
}
