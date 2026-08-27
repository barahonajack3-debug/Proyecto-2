package excepciones;

/**
 * Se lanza cuando se intenta registrar un espacio con un número ya existente.
 */
public class NumeroEspacioDuplicadoException extends CajaAlmacenamientoException {

    public NumeroEspacioDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
