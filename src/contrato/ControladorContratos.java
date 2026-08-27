/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contrato;

import Espacio.GestorEspacios;
import Espacio.TipoEspacio;
import clientes.Cliente;
import clientes.GestorCliente;
import excepciones.CambioEstadoIncorrectoException;
import excepciones.ClienteNoEncontradoException;
import excepciones.EspacioNoDisponibleException;
import excepciones.FechaNoValidaExcepcion;
import java.time.LocalDate;
import java.util.ArrayList;
import serviciosAdicionales.ServicioAdicional;
/**
 *
 * @author USER
 */
public class ControladorContratos {
    //=====Atributos=====
    private GestorContratos gestorContratos;
    private GestorCliente gestorCliente;
    private GestorEspacios gestorEspacios;
    
    //=====Constructor=====
    public ControladorContratos(GestorContratos gestorContratos, GestorCliente gestorCliente, GestorEspacios gestorEspacios) {
        this.gestorContratos = gestorContratos;
        this.gestorCliente = gestorCliente;
        this.gestorEspacios = gestorEspacios;
    }
    
     //=====Funciones=====
    public Contratos crearContrato(String identificacionCliente, TipoEspacio tipo, LocalDate Fecha_Inicio,
            LocalDate Fecha_Fin, ArrayList<ServicioAdicional> servicios)
            throws ClienteNoEncontradoException, FechaNoValidaExcepcion, EspacioNoDisponibleException {
        return gestorContratos.crearContrato(identificacionCliente, tipo, Fecha_Inicio, Fecha_Fin,
            servicios, gestorCliente, gestorEspacios);
    }
 
    public void activarContrato(Contratos contrato) throws CambioEstadoIncorrectoException {
        contrato.Activar();
    }
 
    public void finalizarContrato(Contratos contrato) throws CambioEstadoIncorrectoException {
        contrato.Finalizar();
    }
 
    public void cancelarContrato(Contratos contrato) throws CambioEstadoIncorrectoException {
        contrato.Cancelar();
    }
 
    public Cliente buscarCliente(String identificacion) {
        return gestorCliente.buscarPorId(identificacion);
    }

    public Contratos buscarContratoPorNumero(int numero) {
        return gestorContratos.buscarPorNumero(numero);
    }

    public ArrayList<Contratos> buscarContratos(Integer numeroContrato, String identificacionCliente,
            Integer numeroEspacio, EstadoContratos estado) {
        return gestorContratos.buscarConFiltro(numeroContrato, identificacionCliente, numeroEspacio, estado);
    }
}