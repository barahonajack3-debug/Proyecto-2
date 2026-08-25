/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contrato;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ControladorContratos {
    //======Atributos======
    private ArrayList<Contratos> contratos=new ArrayList<>();
    private int Numero;
    
    //======Metodos get======
    public ArrayList<Contratos> getContratos() {
        return contratos;
    }
    
    //======Constructor======
    public ControladorContratos() {
        this.contratos=new ArrayList<>();
        this.Numero = Numero;
    }
    
    
}
