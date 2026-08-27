package Espacio;

import excepciones.EspacioOcupadoException;
import excepciones.NumeroEspacioDuplicadoException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GestorEspacios {

    private final LinkedList<Espacios> espacios;

    public GestorEspacios() {
        espacios = new LinkedList<>();
    }

    public void agregarEspacio(Espacios espacio) throws NumeroEspacioDuplicadoException {
        if (espacio == null) {
            throw new IllegalArgumentException("Debe indicar un espacio.");
        }
        if (buscarPorNumero(espacio.getNumeroEspacio()) != null) {
            throw new NumeroEspacioDuplicadoException(
                    "Ya existe el espacio número " + espacio.getNumeroEspacio() + ".");
        }
        espacios.add(espacio);
    }

    public Espacios buscarPorNumero(int numeroEspacio) {
        for (Espacios espacio : espacios) {
            if (espacio.getNumeroEspacio() == numeroEspacio) {
                return espacio;
            }
        }
        return null;
    }

    public void actualizarEspacio(int numeroEspacio, TipoEspacio tipo,
            double tamaño, double precioMensual) {
        Espacios espacio = buscarPorNumero(numeroEspacio);
        if (espacio == null) {
            throw new IllegalArgumentException("No existe el espacio.");
        }
        espacio.setTipo(tipo);
        espacio.setTamaño(tamaño);
        espacio.setPrecioMensual(precioMensual);
    }

    public void eliminarEspacio(int numeroEspacio) throws EspacioOcupadoException {
        Espacios espacio = buscarPorNumero(numeroEspacio);
        if (espacio == null) {
            throw new IllegalArgumentException("No existe el espacio.");
        }
        if (!espacio.puedeEliminarse()) {
            throw new EspacioOcupadoException(
                    "No se puede eliminar el espacio " + numeroEspacio + " porque está ocupado.");
        }
        espacios.remove(espacio);
    }

    public List<Espacios> buscarConFiltros(Integer numeroEspacio, TipoEspacio tipo,
            Boolean disponible, Double precioMinimo, Double precioMaximo) {
        if (precioMinimo != null && precioMaximo != null && precioMinimo > precioMaximo) {
            throw new IllegalArgumentException("El precio mínimo no puede ser mayor al máximo.");
        }
        List<Espacios> resultado = new ArrayList<>();

        for (Espacios espacio : espacios) {
            if (numeroEspacio != null && espacio.getNumeroEspacio() != numeroEspacio) {
                continue;
            }
            if (tipo != null && espacio.getTipo() != tipo) {
                continue;
            }
            if (disponible != null && espacio.isDisponible() != disponible) {
                continue;
            }
            if (precioMinimo != null && espacio.getPrecioMensual() < precioMinimo) {
                continue;
            }
            if (precioMaximo != null && espacio.getPrecioMensual() > precioMaximo) {
                continue;
            }
            resultado.add(espacio);
        }
        return resultado;
    }

}
