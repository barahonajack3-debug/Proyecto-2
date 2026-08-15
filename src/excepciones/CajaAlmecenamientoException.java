/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author USER
 */
public class CajaAlmecenamientoException extends Exception{
    
    public CajaAlmecenamientoException(String mensaje){
        super(mensaje);
    }
    
    public CajaAlmecenamientoException(String mensaje, Throwable causa){
        super(mensaje,causa);
    }
}
