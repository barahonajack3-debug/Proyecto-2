/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author USER
 */
public class CajaAlmacenamientoException extends Exception{
    
    public CajaAlmacenamientoException(String mensaje){
        super(mensaje);
    }
    
    public CajaAlmacenamientoException(String mensaje, Throwable causa){
        super(mensaje,causa);
    }
}
