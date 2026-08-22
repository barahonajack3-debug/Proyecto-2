/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Espacio;

import excepciones.NumeroEspacioDuplicadoException;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ControladorEspacio {

    private final GestorEspacios gestorEspacios;

    public ControladorEspacio() {
        gestorEspacios = new GestorEspacios();
    }

    public void guardarEspacio(int numeroEspacio, TipoEspacio tipo,
            double tamaño, double precioMensual) throws NumeroEspacioDuplicadoException {
        Espacios espacio = new Espacios(numeroEspacio, tipo);
        espacio.setTamaño(tamaño);
        espacio.setPrecioMensual(precioMensual);
        gestorEspacios.agregarEspacio(espacio);
    }

    public Espacios buscarPorNumero(int numeroEspacio) {
        return gestorEspacios.buscarPorNumero(numeroEspacio);
    }

    public List<Espacios> buscarConFiltros(Integer numeroEspacio, TipoEspacio tipo,
            Boolean disponible, Double precioMinimo, Double precioMaximo) {
        return gestorEspacios.buscarConFiltros(numeroEspacio, tipo, disponible,
                precioMinimo, precioMaximo);
    }
}
