package co.pragma.automatizacion.exceptions;

@SuppressWarnings("serial")
public class AddProductException extends AssertionError {

  public AddProductException(String message, Throwable cause) {
    super(message, cause);
  }
}
