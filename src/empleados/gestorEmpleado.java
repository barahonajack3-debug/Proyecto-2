/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

import excepciones.EmpleadoNoencontradoException;
import excepciones.IDduplicadaException;
import java.util.ArrayList;


/**
 *
 * @author EMMAXZZ
 */
public class gestorEmpleado {
    

    private ArrayList<Empleado> empleados;
    
    public gestorEmpleado(){
    empleados = new ArrayList<>();
}
    public void agregarEmpleado(Empleado empleado) 
      throws IDduplicadaException {
       for (Empleado e : empleados) {
          if (e.getID().equals(empleado.getID())) {
            throw new IDduplicadaException(
             "Ya existe un empleado con esa identificación"
                );
            }
        }
        empleados.add(empleado);
    } 
    public Empleado buscarEmpleado(String ID){
        
       for(Empleado empleado : empleados){
           if(empleado.getID().equals(ID)){
               return empleado;
           }
       }
      return null;
    }
    
    public void eliminarEmpleado(String ID)
        throws EmpleadoNoencontradoException{
        Empleado empleado = buscarEmpleado(ID);
       if (empleado == null){
          throw new EmpleadoNoencontradoException(
                  "No existe empleado con ese ID"
          );
       }
       empleados.remove(empleado);
    }
    
    public void actualizarempleado(String ID,String Nombre,String Telefono,Puesto puesto)
        throws EmpleadoNoencontradoException{
        Empleado empleado = buscarEmpleado(ID);
        if(empleado == null){
            throw new EmpleadoNoencontradoException(
            "no existe empleado con ese ID");
        }
        empleado.setNombre(Nombre);
        empleado.setTelefono(Telefono);
        empleado.setPuesto(puesto);
    } 
    
        
    }

