package Espacio;

import excepciones.EspacioOcupadoException;
import excepciones.NumeroEspacioDuplicadoException;
import java.util.List;

/**
 * Prueba manual de las reglas principales del módulo de espacios.
 */
public class PruebaGestorEspacios {

    public static void main(String[] args) throws Exception {
        GestorEspacios gestor = new GestorEspacios();
        Espacios pequeno = new Espacios(1, TipoEspacio.PEQUEÑO);
        Espacios mediano = new Espacios(2, TipoEspacio.MEDIANO);

        gestor.agregarEspacio(pequeno);
        gestor.agregarEspacio(mediano);
        verificar(gestor.obtenerEspacios().size() == 2,
                "Deben registrarse dos espacios.");

        verificarNumeroDuplicado(gestor);
        verificarFiltros(gestor);
        verificarEliminacionEspacioOcupado(gestor, pequeno);

        gestor.eliminarEspacio(1);
        verificar(gestor.buscarPorNumero(1) == null,
                "El espacio disponible debe eliminarse.");

        System.out.println("Prueba de GestorEspacios finalizada correctamente.");
    }

    private static void verificarNumeroDuplicado(GestorEspacios gestor) throws Exception {
        try {
            gestor.agregarEspacio(new Espacios(1, TipoEspacio.GRANDE));
            throw new AssertionError("Se permitió registrar un número duplicado.");
        } catch (NumeroEspacioDuplicadoException e) {
            // Resultado esperado.
        }
    }

    private static void verificarFiltros(GestorEspacios gestor) {
        List<Espacios> resultado = gestor.buscarConFiltros(
                null, TipoEspacio.MEDIANO, true, 40000.0, 50000.0);
        verificar(resultado.size() == 1 && resultado.get(0).getNumeroEspacio() == 2,
                "El filtro por tipo, disponibilidad y precio no devolvió el espacio esperado.");
    }

    private static void verificarEliminacionEspacioOcupado(GestorEspacios gestor,
            Espacios espacio) throws Exception {
        espacio.marcarOcupado();
        try {
            gestor.eliminarEspacio(1);
            throw new AssertionError("Se permitió eliminar un espacio ocupado.");
        } catch (EspacioOcupadoException e) {
            // Resultado esperado.
        }
        espacio.marcarDisponible();
    }

    private static void verificar(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError(mensaje);
        }
    }
}
