package exceptions;

/**
 *
 * @author efapro01.23
 */
public class NomeInvalidoException extends Exception {

    /**
     * Creates a new instance of <code>NomeInvalidoException</code> without
     * detail message.
     */
    public NomeInvalidoException() {
    }

    /**
     * Constructs an instance of <code>NomeInvalidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NomeInvalidoException(String msg) {
        super(msg);
        // gravar em ficheiro
    }
}
