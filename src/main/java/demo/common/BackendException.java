package demo.common;

public class BackendException extends RuntimeException {

    public BackendException() {
        super();
    }

    public BackendException(String message) {
        super(message);
    }
}
