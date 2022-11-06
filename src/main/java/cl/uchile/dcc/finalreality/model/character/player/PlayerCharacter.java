package cl.uchile.dcc.finalreality.model.character.player;

/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.*;

/**
 * A {@link GameCharacter} that can equip a weapon.
 */
public interface PlayerCharacter extends GameCharacter {
  /**
   * Equips a weapon to the character.
   */
  void equip(Weapon weapon) throws InvalidWeaponAssignmentException;
  void equipSword(Sword sword) throws InvalidWeaponAssignmentException;
  void equipAxe(Axe axe) throws InvalidWeaponAssignmentException;
  
  void equipKnife(Knife knife) throws InvalidWeaponAssignmentException;
  void equipStaff(Staff staff) throws InvalidWeaponAssignmentException;
  
  void equipBow(Bow bow) throws InvalidWeaponAssignmentException;
  /**
   * Return this character's equipped weapon.
   */
  Weapon getEquippedWeapon();
}
