/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contrato;

import Espacio.Espacios;
import Espacio.GestorEspacios;
import Espacio.TipoEspacio;
import excepciones.ClienteNoEncontradoException;
import excepciones.EspacioNoDisponibleException;
import excepciones.FechaNoValidaExcepcion;
import java.time.LocalDate;
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

    public Contratos crearContrato(String identificacionCliente,TipoEspacio tipo,LocalDate Inicio_Fecha,LocalDate Fin_Fecha,
        ArrayList<ServicioAdicional> servicios,GestorCliente gestorcliente,GestorEspacios gestorespacio)
        throws ClienteNoEncontradoException,FechaNoValidaExcepcion,EspacioNoDisponibleException{
        //Validar que el cliente exista
        Cliente.cliente=GestorClientes.BuscarPorIdentificacion(identificcionCliente);
        if(cliente==null){
            throw new ClienteNoEncontradoException("No existe ningún cliente registrado con identificación " + identificacionCliente
                + "Puede registrarlo desde la opción de Clientes");
        }
        //Buscar un espacio del tipo pedido que no tenga conflicto de fechas
        Espacios espacioAsignado= buscarEspacioSinConflicto(tipo,Inicio_Fecha,Fin_Fecha,gestorespacio);
        if(espacioAsignado==null){
            throw new EspacioNoDisponibleException("No hay espacio disponible de tipo " + tipo + " para el periodo seleccionado");
        }
        //Crear el contrato (el constructor deja el estado en PENDIENTE)
        Contratos nuevoContrato= Contratos(Numero,cliente,espacioAsignado,Inicio_Fecha,Fin_Fecha);
        //Validar fechas (fecha final posterior a inicial, no nulas, etc.)
        nuevoContrato.validarFechas();
        //Agregar servicios adicionales, si los hay
        if(servicios!=null){
            for(ServicioAdicional servicio: servicios){
                nuevoContrato.agregarServicios(servicios);
            }
        }
        contratos.add(nuevoContrato);
        Numero++;
        return nuevoContrato;
    }
    
    //Recorre los espacios del tipo solicitado y devuelve el primero
    //que no tenga conflicto de fechas con ningún contrato existente.
    private Espacios buscarEspacioSinConflicto(){
        
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
