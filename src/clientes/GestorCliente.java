/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;

import java.util.LinkedList;
import excepciones.ClienteConContratosVinculadosException;
import excepciones.ClienteNoEncontradoException;
import excepciones.IDduplicadaException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dario R
 */
public class GestorCliente {
    private final LinkedList<Cliente> clientes;
    public GestorCliente(){
        clientes = new LinkedList<>();
    }
    public void agregarCliente (Cliente cliente) throws IDduplicadaException{
       {
       for (Cliente  c: clientes) {
          if (cliente.getIdentificacion().equals(cliente.getIdentificacion())) {
            throw new IDduplicadaException(
             "Ya existe un empleado con esa identificación"
                );
            }
        }
        clientes.add(cliente);
    } 
    }
    public Cliente buscarPorId(String identificacion){
        for (int i=0; i<clientes.size();i++){
            Cliente cliente= clientes.get(i);
            if(cliente.getIdentificacion().equals(identificacion)){
                return cliente;
            }
        }
        return null;
    }
    public void actualizarCliente (String identificacion, String nombreCompleto, 
            String telefono, String correoElectronico)throws ClienteNoEncontradoException {
        Cliente cliente = obtenerClienteRegistrado(identificacion);
        cliente.setNombreCompleto(nombreCompleto);
        cliente.setTelefono(telefono);
        cliente.setCorreoElectronico(correoElectronico);
        
    }

    public void eliminarCliente (String identificacion)
    throws ClienteNoEncontradoException, ClienteConContratosVinculadosException {
            Cliente cliente =obtenerClienteRegistrado(identificacion);
            clientes.remove(cliente);
    }
    public List<Cliente> buscarporFiltro( String identificacion, String nombreCompleto){
        List<Cliente> resultado = new ArrayList<>();
         for (int i=0; i<clientes.size();i++){
            Cliente cliente= clientes.get(i);
            if (identificacion != null && !cliente.getIdentificacion().contains(identificacion)) {
                continue;
            }
            if (nombreCompleto != null && !cliente.getNombreCompleto().toLowerCase()
                    .contains(nombreCompleto.toLowerCase())) {
                continue;
            }
            resultado.add(cliente);
         }
         return resultado;
    }
    public List<Cliente> obtenerClientes() {
        List<Cliente> copia = new ArrayList<>();
        for (int i = 0; i < clientes.size(); i++) {
            copia.add(clientes.get(i));
        }
        return copia;
    }
   private Cliente obtenerClienteRegistrado(String identificacion) throws ClienteNoEncontradoException {
        Cliente cliente = buscarPorId(identificacion);
        if (cliente == null) {
            throw new ClienteNoEncontradoException("Cliente no encontrado");
        }
        return cliente;
    }
}
