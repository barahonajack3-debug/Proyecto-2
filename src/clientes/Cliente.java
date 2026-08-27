/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Dario R
 */
public class Cliente extends Persona {
    private final LocalDate fechaNacimiento;
    private String correoElectronico;

    public Cliente(LocalDate fechaNacimiento, String correoElectronico, String identificacion, String nombreCompleto, String telefono) {
        super(identificacion, nombreCompleto, telefono);
        validarIdentificacion(identificacion);
        validarNombre(nombreCompleto);
        validarTelefono(telefono);
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        validarFechaNacimiento(fechaNacimiento);
        validarMayorEdad(fechaNacimiento);
        validarCorreo(correoElectronico);
        
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public int calcularEdad(){
       return Period.between(fechaNacimiento, LocalDate.now()).getYears();    
   }
    private static void validarFechaNacimiento (LocalDate fechaNacimiento){
        if (fechaNacimiento == null)
            throw new IllegalArgumentException("La fecha de nacimiento es obligatoria ");
    }
    
    private static void validarMayorEdad(LocalDate fechaNacimiento) {
    int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
    if (edad < 18) {
        throw new IllegalArgumentException("El cliente debe ser mayor de edad (18 años o más).");
    }
  }
    private void validarCorreo(String correo){
        if (correo == null || correo.trim().isEmpty()){
            throw new IllegalArgumentException ("El correo es obligatorio");
        }
        String c = correo.trim();
        if (!c.contains("@") || !c.contains(".")){
            throw new IllegalArgumentException("El correo electrónico no tiene un formato válido.");
        }
    }
}
    
