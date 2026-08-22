package excepciones;

/**
 * Se lanza cuando se intenta eliminar un espacio que está alquilado.
 */
public class EspacioOcupadoException extends CajaAlmecenamientoException {

    public EspacioOcupadoException(String mensaje) {
        super(mensaje);
    }
}
