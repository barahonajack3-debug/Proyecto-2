/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviciosAdicionales;
import java.util.ArrayList;
/**
 *
 * @author EMMAXZZ
 */
public class gestorServicio {
     private ArrayList<ServicioAdicional> servicios;
       
     public gestorServicio() {
        servicios = new ArrayList<>();
    }
     
     public void agregarServicio(ServicioAdicional servicio){
         servicios.add(servicio);
     }
     
     public ServicioAdicional buscarServicio(int codigo){
         for (ServicioAdicional servicio : servicios) {
             if (servicio.getCodigo() == codigo) {
                return servicio;
        
         }
     }
         return null;
  }
     
     public void actualizarServicio(int codigo, String descripcion, double precio) {
        ServicioAdicional servicio = buscarServicio(codigo);
        if (servicio != null) {
            servicio.setDescripcion(descripcion);
            servicio.setPrecio(precio);
        }
    }
      public void eliminarServicio(int codigo) {
        ServicioAdicional servicio = buscarServicio(codigo);
        if (servicio != null) {
            servicios.remove(servicio);
        }
    }

    public ArrayList<ServicioAdicional> getServicios() {
        return servicios;
    }
}
