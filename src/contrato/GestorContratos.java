/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contrato;

import Espacio.Espacios;
import Espacio.GestorEspacios;
import Espacio.TipoEspacio;
import clientes.Cliente;
import clientes.GestorCliente;
import excepciones.ClienteNoEncontradoException;
import excepciones.EspacioNoDisponibleException;
import excepciones.FechaNoValidaExcepcion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import serviciosAdicionales.ServicioAdicional;

/**
 *
 * @author USER
 */
public class GestorContratos {
    //=====Atributos=====
    private static GestorContratos instancia;
    private ArrayList<Contratos> contratos;
    private HashMap<Integer, Contratos> mapaContratos;
    private int Numero;
    
    //=====Metodos get=====
    public ArrayList<Contratos> getContratos() {
        return contratos;
    }
    
    //Busqueda directa por numero de contrato usando el HashMap
    public Contratos buscarPorNumero(int numero) {
        return mapaContratos.get(numero);
    }
    
    //=====Constructor=====
    private GestorContratos() {
        this.contratos = new ArrayList<>();
        this.mapaContratos = new HashMap<>();
        this.Numero = 1;
    }

    public static GestorContratos getInstancia() {
        if (instancia == null) {
            instancia = new GestorContratos();
        }
        return instancia;
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
        Cliente cliente=gestorcliente.buscarPorId(identificacionCliente);
        if(cliente==null){
            throw new ClienteNoEncontradoException("No existe ningún cliente registrado con identificación:" + identificacionCliente
                + " Puede registrarlo desde la opción de Clientes");
        }
        //Buscar un espacio del tipo pedido que no tenga conflicto de fechas
        Espacios espacioAsignado = buscarEspacioSinConflicto(tipo,Inicio_Fecha,Fin_Fecha,gestorespacio);
        if(espacioAsignado==null){
            throw new EspacioNoDisponibleException("No hay espacio disponible de tipo " + tipo + " para el periodo seleccionado");
        }
        //Crear el contrato (el constructor deja el estado en PENDIENTE)
        Contratos nuevoContrato= new Contratos(Numero,cliente,espacioAsignado,Inicio_Fecha,Fin_Fecha);
        //Validar fechas (fecha final posterior a inicial, no nulas, etc.)
        nuevoContrato.validarFechas();
        //Agregar servicios adicionales, si los hay
        if(servicios!=null){
            for(ServicioAdicional servicio: servicios){
                nuevoContrato.agregarServicios(servicio);
            }
        }
        contratos.add(nuevoContrato);
        mapaContratos.put(nuevoContrato.getNumeroContrato(), nuevoContrato);
        Numero++;
        return nuevoContrato;
    }
    
    //Recorre los espacios del tipo solicitado y devuelve el primero
    //que no tenga conflicto de fechas con ningún contrato existente.
    private Espacios buscarEspacioSinConflicto(TipoEspacio tipo,LocalDate Inicio_Fecha,LocalDate Fin_Fecha,
        GestorEspacios gestorespacio){
        List<Espacios> candidatos=gestorespacio.buscarConFiltros(null,tipo,null,null,null);
        for (Espacios espacio : candidatos) {
            if (!verificarConflictosFechas(espacio, Inicio_Fecha, Fin_Fecha)) {
                return espacio;
            }
        }
        return null;
    }

    //Cuenta cuantos espacios del tipo pedido quedan libres para el periodo dado.
    public int contarEspaciosDisponibles(TipoEspacio tipo,LocalDate Inicio_Fecha,LocalDate Fin_Fecha,
        GestorEspacios gestorespacio){
        int contador = 0;
        List<Espacios> candidatos = gestorespacio.buscarConFiltros(null,tipo,null,null,null);
        for (Espacios espacio : candidatos) {
            if (!verificarConflictosFechas(espacio, Inicio_Fecha, Fin_Fecha)) {
                contador++;
            }
        }
        return contador;
    }

    //Indica si el cliente tiene contratos PENDIENTES o ACTIVOS (no puede eliminarse).
    public boolean tieneContratosPendientesOActivos(String identificacionCliente){
        for(Contratos contrato:contratos){
            boolean igualCliente=contrato.getCliente().getIdentificacion().equals(identificacionCliente);
            boolean estadoRevelado=contrato.getEstado()== EstadoContratos.PENDIENTE
            || contrato.getEstado() == EstadoContratos.ACTIVO;
            if(igualCliente && estadoRevelado){
                return true;
            }
        }
        return false;
    }
    
    //Funcion para verificar si el espacio dado tiene conflicto de fechas con algún
    //contrato PENDIENTE o ACTIVO ya registrado.
    public boolean verificarConflictosFechas(Espacios espacio,LocalDate Inicio_Fecha,LocalDate Fin_Fecha){
        for(Contratos contrato:contratos){
            boolean mismoEspacio=contrato.getEspacio().getNumeroEspacio()==espacio.getNumeroEspacio();
            boolean estadoRevelado=contrato.getEstado()== EstadoContratos.PENDIENTE
            || contrato.getEstado() == EstadoContratos.ACTIVO;
            if(mismoEspacio && estadoRevelado){
                boolean chocan=!Inicio_Fecha.isAfter(contrato.getFin_Fecha()) && !Fin_Fecha.isBefore(contrato.getInicio_Fecha());
                if(chocan){
                    return true;
                }
            }
        }return false;
    }
    
    //Funcion para buscar con filtros para FrmBuscarContrato.
    //Cualquier parámetro en null/vacío se ignora.
    public ArrayList<Contratos> buscarConFiltro(Integer numeroContrato,String identificacionCliente,
        Integer numeroEspacio,EstadoContratos estado,LocalDate fechaDesde,LocalDate fechaHasta){
        ArrayList<Contratos> resultado= new ArrayList<>();
        for(Contratos contrato:contratos){
            if(numeroContrato!=null && contrato.getNumeroContrato()!=numeroContrato){
                continue;
            }
            if(identificacionCliente!=null && !contrato.getCliente().getIdentificacion().equals(identificacionCliente)){
                continue;
            }
            if(numeroEspacio!=null && contrato.getEspacio().getNumeroEspacio()!=numeroEspacio){
                continue;
            }
            if(estado!=null && contrato.getEstado()!= estado){
                continue;
            }
            if(fechaDesde!=null && contrato.getFin_Fecha().isBefore(fechaDesde)){
                continue;
            }
            if(fechaHasta!=null && contrato.getInicio_Fecha().isAfter(fechaHasta)){
                continue;
            }
            resultado.add(contrato);
        }
        return resultado;
    }
}