package cl.uchile.dcc.finalreality.exceptions;

/**
 * This error represents an invalid use of a Player whitout a weapon assigned.
 *
 * @author ~Lukas Vasquez~
 */

public class NullWeaponException extends Exception {
  public  NullWeaponException() {
    super("Character does not have a weapon.");
  }
}
