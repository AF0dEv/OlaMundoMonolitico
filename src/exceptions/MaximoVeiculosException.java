package exceptions;

/**
 *
 * @author efapro01.23
 */
public class MaximoVeiculosException extends Exception {

    /**
     * Creates a new instance of <code>MaximoVeiculosException</code> without
     * detail message.
     */
    public MaximoVeiculosException() {
    }

    /**
     * Constructs an instance of <code>MaximoVeiculosException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MaximoVeiculosException(String msg) {
        super(msg);
        // gravar em ficheiro
    }
}
