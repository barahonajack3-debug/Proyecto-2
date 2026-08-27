/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;
import excepciones.ClienteConContratosVinculadosException;
import excepciones.ClienteNoEncontradoException;
import excepciones.IDduplicadaException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Dario R
 */
public class ControladorCliente {
  private final GestorCliente gestorCliente;

    public ControladorCliente() {
        gestorCliente = GestorCliente.getInstancia();
    }
    public void guardarCliente(String identificacion, String nombreCompleto,
    String telefono, LocalDate fechaNacimiento, String correoElectronico)
    throws IDduplicadaException{
    Cliente cliente = new Cliente(fechaNacimiento, correoElectronico, identificacion,
     nombreCompleto, telefono);
    gestorCliente.agregarCliente(cliente);
    }
    public Cliente buscarPorId ( String identificacion){
    return gestorCliente.buscarPorId(identificacion);
}
    public void actualizarCliente(String identificacion, String nombreCompleto,
    String telefono, String correoElectronico)
    throws ClienteNoEncontradoException{
        gestorCliente.actualizarCliente(identificacion, nombreCompleto, telefono, correoElectronico);
    }
    public void eliminarCliente(String identificacion)
    throws ClienteNoEncontradoException, ClienteConContratosVinculadosException {
        gestorCliente.eliminarCliente(identificacion);
    }
    public List<Cliente> buscarConFiltros (String identificacion, String nombre){
        return gestorCliente.buscarporFiltro(identificacion, nombre);
    }
    public List<Cliente> obtenerClientes (){
        return gestorCliente.obtenerClientes();
    }
}