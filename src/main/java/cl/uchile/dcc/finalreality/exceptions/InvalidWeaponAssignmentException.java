package cl.uchile.dcc.finalreality.exceptions;

/**
 * This error is used to represent an invalid weapon assignment.
 *
 * @author ~Lukas Vasquez~
 */

public class InvalidWeaponAssignmentException extends Exception {
  public InvalidWeaponAssignmentException() {
    super("Invalid weapon assignment.");
  }
}
