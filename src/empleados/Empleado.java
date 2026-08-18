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
    private Puesto puesto;
    private double Salario;

    public String getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return Salario;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
        this.Salario = puesto.getSalario();
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    public Empleado(String ID, String Nombre, Puesto puesto) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.puesto = puesto;
        this.Salario = Salario;
    }
    
 
}
