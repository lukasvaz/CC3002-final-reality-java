package cl.uchile.dcc.finalreality.exceptions;

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

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
