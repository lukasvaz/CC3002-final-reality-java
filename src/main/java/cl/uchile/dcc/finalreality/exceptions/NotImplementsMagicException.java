package cl.uchile.dcc.finalreality.exceptions;

/**
 * This error is used to represent an Invalid Magic use.
 *
 * @author ~Lukas Vasquez~
 */

public class NotImplementsMagicException extends Exception {
  public NotImplementsMagicException() {
    super("This character does not implements this magic.");
  }
}
