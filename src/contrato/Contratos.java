/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contrato;

import Espacio.Espacios;
import excepciones.CambioEstadoIncorrectoException;
import excepciones.FechaNoValidaExcepcion;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Contratos {
    //=====Atributos===== 
    private int NumeroContrato;
    private Cliente cliente;
    private Espacios espacio;
    private LocalDate Inicio_Fecha;
    private LocalDate Fin_Fecha;
    private EstadoContratos estado;
    private ArrayList<ServicioAdicional> servicioAdicional;

    //=====Metodos get=====
    public int getNumeroContrato() {
        return NumeroContrato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Espacios getEspacio() {
        return espacio;
    }

    public LocalDate getInicio_Fecha() {
        return Inicio_Fecha;
    }

    public LocalDate getFin_Fecha() {
        return Fin_Fecha;
    }

    public EstadoContratos getEstado() {
        return estado;
    }

    public ArrayList<ServicioAdicional> getServicioAdicional() {
        return servicioAdicional;
    }
    
    //=====Constructor=====
    public Contratos(int NumeroContrato, Cliente cliente, Espacios espacio, LocalDate Inicio_Fecha, LocalDate Fin_Fecha) {
        this.NumeroContrato = NumeroContrato;
        this.cliente = cliente;
        this.espacio = espacio;
        this.Inicio_Fecha = Inicio_Fecha;
        this.Fin_Fecha = Fin_Fecha;
        this.estado = EstadoContratos.PENDIENTE;
        this.servicioAdicional = new ArrayList<>();
    }
    
    //=====Funciones======
    //Funcion para agregar servicios adicionales
    public void agregarServicios(ServicioAdicional servicio){
        servicioAdicional.add(servicio);
    }
    
    //Funcion para validar fechas con excepciones 
    public void validarFechas() throws FechaNoValidaExcepcion{
        if(Inicio_Fecha == null || Fin_Fecha == null){
            throw new FechaNoValidaExcepcion("Debe indicar fecha de inicio y fecha de fin");
        }
        if(Fin_Fecha.isBefore(Inicio_Fecha)){
            throw new FechaNoValidaExcepcion("La fecha fin no puede ser anterior a la fecha de inicio");
        }
        if(Fin_Fecha.isEqual(Inicio_Fecha)){
            throw new FechaNoValidaExcepcion("El periodo de contrato debe ser al menos un día");
        }
    }
    
    //Funcion para calcular dias, se importo ChoroUnit para facilitar esta funcioón 
    //ChronoUnit es una lista de unidades de tiempo (como días, meses o años)
    private long calcularDias(){
        return ChronoUnit.DAYS.between(Inicio_Fecha, Fin_Fecha);
    }
    
    //Funcion para calcular periodo de alquiler
    private int calcularPeriodoAlquiler(){
        long Dias=calcularDias();
        return (int)((Dias+30-1)/30);
    }
    
    //Funcion para calcular el precio segun espacio y servicios adicionales
    private double calcularTotal(){
        //Falta la clase espacio para poder sacar el espacio por tamaño
        double totalEspacio=espacio.getPrecioMensual()*calcularPeriodoAlquiler(); 
        double totalServicios=0.0;
        for (ServicioAdicional servicio : servicioAdicional) {
            totalServicios+=servicio.getPrecio();
        }
        return totalEspacio+totalServicios;
    }
    
    //Funcio para calcular el subtotal sin impuestos
    public double calcularSubTotal(){
        return calcularTotal()/1.13;
    }
     //Funcion para calcular el total de impuestos
    public double calcularImpuestos(){
        return calcularTotal() - calcularSubTotal();
    }
    
    //Funcion para activar estado del contrato
    public void Activar() throws CambioEstadoIncorrectoException{
        if(estado != EstadoContratos.PENDIENTE){
            throw new CambioEstadoIncorrectoException("Solo se puede activar un contraro en estado PENDIENTE."
                + "Estado actual: "+estado);
        }
        this.estado=EstadoContratos.ACTIVO;
        //Falta la clase espacio para podes marcar como espacio ocupado
        espacio.marcarOcupado();
    }
    
    //Funcion para finalizar estado del contrato
    public void Finalizar() throws CambioEstadoIncorrectoException{
        if(estado != EstadoContratos.ACTIVO){
            throw new CambioEstadoIncorrectoException("Solo se puede finalizar un contraro en estado ACTIVO."
                + "Estado actual: "+estado);
        }
        this.estado=EstadoContratos.FINALIZADO;
        //Falta la clase espacio para podes marcar como espacio disponible
        espacio.marcarDisponible();
    }
    
    //Funcion para cancelr estado de contrato
    public void Cancelar() throws CambioEstadoIncorrectoException{
        if(estado != EstadoContratos.PENDIENTE){
            throw new CambioEstadoIncorrectoException("Solo se puede cancelar un contraro en estado PENDIENTE."
                + "Estado actual: "+estado);
        }
        this.estado=EstadoContratos.CANCELADO;
        //Falta la clase espacio para podes marcar como espacio disponible
        espacio.marcarDisponible();
    }
}