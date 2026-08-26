/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;

/**
 *
 * @author Dario R
 */
public abstract class Persona {
    private String identificacion;
    private String nombreCompleto;
    private String telefono;

    public Persona(String identificacion, String nombreCompleto, String telefono) {
        this.identificacion = identificacion;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
 
    protected static void validarIdentificacion (String identificacion){
        if (identificacion == null || identificacion.isEmpty())
            throw new IllegalArgumentException("La identificación es obligatoria.");
    }
    protected static void validarNombre (String nombreCompleto){
        if (nombreCompleto == null || nombreCompleto.isEmpty())
            throw new IllegalArgumentException("El nombre es obligatorio");
    }
    protected static void validarTelefono(String telefono){
        if (telefono == null || telefono.isEmpty())
            throw new IllegalArgumentException("El numero telefonico es obligatorio");
    }

    @Override
    public String toString() {
        return "Persona{" + "identificacion=" + identificacion + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + '}';
    }
}
