/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;
import excepciones.IDduplicadaException;
import excepciones.EmpleadoNoencontradoException;
/**
 *
 * @author EMMAXZZ
 */
public class ControlardorEmpleado {
    private Empleado empleado;
    
    private gestorEmpleado gestor;
   
  public ControlardorEmpleado(gestorEmpleado gestor) {
      this.gestor = gestor;
  }
  public void agregarEmpleado(String ID,String Nombre,String Telefono, Puesto puesto)
       throws IDduplicadaException{
      Empleado empleado = new Empleado(ID,Nombre,Telefono,puesto);
       gestor.agregarEmpleado(empleado);
  }
    public Empleado buscarEmpleado(String ID){
        return gestor.buscarEmpleado(ID);
    }
    public void actualizarempleado(String ID, String Nombre,
            String Telefono, Puesto puesto)
        throws EmpleadoNoencontradoException {
        
        gestor.actualizarempleado(ID, Nombre, Telefono, puesto);
    }
    public void eliminarEmpleado(String ID)
        throws EmpleadoNoencontradoException{
        gestor.eliminarEmpleado(ID);
    }
  }

