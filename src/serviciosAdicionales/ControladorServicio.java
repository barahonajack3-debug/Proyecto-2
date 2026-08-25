/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviciosAdicionales;
import excepciones.ServicioNoencontradoException;
import java.util.ArrayList;
/**
 *
 * @author EMMAXZZ
 */
public class ControladorServicio {
    private gestorServicio gestor;
    
      public ControladorServicio(gestorServicio gestor) {
        this.gestor = gestor;
    }

   public void agregarServicio(String nombre, String descripcion, double precio) {
         ServicioAdicional servicio = new ServicioAdicional(nombre, descripcion, precio);
         gestor.agregarServicio(servicio);
   }
   public ServicioAdicional buscarServicio(int codigo) 
         throws ServicioNoencontradoException {
    return gestor.buscarServicio(codigo);
    }
   public void actualizarServicio(int codigo, String descripcion, double precio)
            throws ServicioNoencontradoException {
            gestor.actualizarServicio(codigo, descripcion, precio);
   }
   
   public void eliminarServicio(int codigo)
         throws ServicioNoencontradoException {
         gestor.eliminarServicio(codigo);
   }
   
   
     public ArrayList<ServicioAdicional> getServicios() {
        return gestor.getServicios();
    }
}
