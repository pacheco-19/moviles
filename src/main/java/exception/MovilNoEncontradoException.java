package exception;

public class MovilNoEncontradoException extends RuntimeException {
    public MovilNoEncontradoException(Long id) {
        super("No existe ningún móvil con id " + id);
    }
}