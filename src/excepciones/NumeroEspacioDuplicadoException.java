package excepciones;

/**
 * Se lanza cuando se intenta registrar un espacio con un número ya existente.
 */
public class NumeroEspacioDuplicadoException extends CajaAlmecenamientoException {

    public NumeroEspacioDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
