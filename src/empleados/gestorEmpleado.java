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
        throws IDduplicadaException{
        if(empleado.getID().isEmpty()||empleado.getNombre().isEmpty()||empleado.getTelefono().isEmpty()){
            throw new IllegalArgumentException("Faltan datos");
        }
        for (Empleado m : empleados){
            if(m.getID().equals(empleado.getID())){
                throw new IDduplicadaException("El ID ya existe");
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
       
        if(Nombre.isEmpty() || Telefono.isEmpty()){
       throw new IllegalArgumentException("Faltan datos");
        }
        Empleado empleado = buscarEmpleado(ID);
        empleado.setNombre(Nombre);
        empleado.setTelefono(Telefono);
        empleado.setPuesto(puesto);
    } 
    
     public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
 }

