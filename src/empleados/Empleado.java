/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

/**
 *
 * @author EMMAXZZ
 */
public class Empleado {
    private String ID;
    private String Nombre;
    private String Puesto;
    private double Salario;

    public String getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getPuesto() {
        return Puesto;
    }

    public double getSalario() {
        return Salario;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    public Empleado(String ID, String Nombre, String Puesto, double Salario) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Puesto = Puesto;
        this.Salario = Salario;
    }
    
   
}
