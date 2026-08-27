package excepciones;

/**
 * Se lanza cuando se intenta eliminar un espacio que está alquilado.
 */
public class EspacioOcupadoException extends CajaAlmacenamientoException {

    public EspacioOcupadoException(String mensaje) {
        super(mensaje);
    }
}
