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
public class GestorContratos {
    //=====Atributos=====
    private ArrayList<Contratos> contratos;
    private int Numero;
    
    //=====Metodos get=====
    public ArrayList<Contratos> getContratos() {
        return contratos;
    }
    
    //=====Constructor=====
    public GestorContratos() {
        this.contratos = new ArrayList<>();
        this.Numero = 1;
    }
    
    //=====Funciones=====
    
    //Funcion para crear contrato
    /**
     * Crea un contrato completo: valida que el cliente exista, busca
     * un espacio del tipo solicitado sin conflicto de fechas, valida
     * las fechas y agrega los servicios adicionales.
     */

    public Contratos crearContrato(){
    
    }
    
    //Recorre los espacios del tipo solicitado y devuelve el primero
    //que no tenga conflicto de fechas con ningún contrato existente.
    private Espacio buscarEspacioSinConflicto(){
        
    }
    
    //Funcion para verificar si el espacio dado tiene conflicto de fechas con algún
    //contrato PENDIENTE o ACTIVO ya registrado.
    public boolean verificarConflictosFechas(){
        
    }
    
    //Funcion para buscar con filtros para FrmBuscarContrato.
    //Cualquier parámetroen null/vacío se ignora.
    public ArrayList<Contratos> buscarConFiltro(){
        
    }
}
