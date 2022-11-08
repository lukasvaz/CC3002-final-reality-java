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
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

/**
 * A {@link GameCharacter} that can equip a weapon.
 */
public interface PlayerCharacter extends GameCharacter {
  /**
   * Equips a weapon to the character.
   */
  void equip(Weapon weapon) throws InvalidWeaponAssignmentException;
  
  /**
   * Equips a Sword to the character.
   */
  void equipSword(Sword sword) throws InvalidWeaponAssignmentException;
  
  /**
   * Equips an Axe to the character.
   */
  void equipAxe(Axe axe) throws InvalidWeaponAssignmentException;
  
  /**
   * Equips a Knife to the character.
   */
  void equipKnife(Knife knife) throws InvalidWeaponAssignmentException;
  
  /**
   * Equips a Staff to the character.
   */
  void equipStaff(Staff staff) throws InvalidWeaponAssignmentException;
  
  /**
   * Equips a Bow to the character.
   */
  void equipBow(Bow bow) throws InvalidWeaponAssignmentException;
  
  /**
   * Return this character's equipped weapon.
   */
  Weapon getEquippedWeapon();
}
