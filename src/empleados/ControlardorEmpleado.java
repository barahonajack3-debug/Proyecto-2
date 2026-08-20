/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

/**
 *
 * @author EMMAXZZ
 */
public class ControlardorEmpleado {
    private Empleado empleado;
    
    public ControlardorEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public Empleado getEmpleado(){
        return empleado;
    }
    
    public void setEmpleado(Empleado empleado){
        this.empleado = empleado;
    }
    
   
}
