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
public class GestorCliente {
    private ArrayList<Cliente> clientes;
 
    public GestorCliente() {
        clientes = new ArrayList<>();
        //Cliente de prueba, identificación 123456789
        clientes.add(new Cliente("123456789", "Cliente de Prueba"));
    }
 
    public Cliente buscarPorIdentificacion(String identificacion) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdentificacion().equals(identificacion)) {
                return cliente;
            }
        }
        return null;
    }
}
