package Exceptions;

public class ItemNaoDisponivelException extends RuntimeException {
    public ItemNaoDisponivelException(String message) {
        super(message);
    }
}
