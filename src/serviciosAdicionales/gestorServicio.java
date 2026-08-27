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
public class gestorServicio {
     private ArrayList<ServicioAdicional> servicios;
       
     public gestorServicio() {
        servicios = new ArrayList<>();
    }
     
     public void agregarServicio(ServicioAdicional servicio){
       if (servicio.getNombre().isEmpty() || servicio.getDescripcion().isEmpty()) {
        throw new IllegalArgumentException("Faltan datos");
    }
    if (servicio.getPrecio() <= 0) {
        throw new IllegalArgumentException("El precio no es valido");
    }
    servicios.add(servicio);
}
     
     
     public ServicioAdicional buscarServicio(int codigo)
      throws ServicioNoencontradoException {
        for (ServicioAdicional servicio : servicios) {
        if (servicio.getCodigo() == codigo) {
            return servicio;
        }
    }   throw new ServicioNoencontradoException("No existe un servicio con ese código");

         
  }
     
     public void actualizarServicio(int codigo, String descripcion, double precio) 
        throws ServicioNoencontradoException {

    ServicioAdicional servicio = buscarServicio(codigo);

    servicio.setDescripcion(descripcion);
    servicio.setPrecio(precio); 
    }
      public void eliminarServicio(int codigo) 
        throws ServicioNoencontradoException {

    ServicioAdicional servicio = buscarServicio(codigo);

    servicios.remove(servicio);
    }

    public ArrayList<ServicioAdicional> getServicios() {
        return servicios;
    }
}
