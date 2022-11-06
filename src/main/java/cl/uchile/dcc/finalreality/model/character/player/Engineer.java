/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import java.util.Objects;

import cl.uchile.dcc.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;


/**
 * A {@link PlayerCharacter} that can equip {@code Axe}s and {@code Bow}s.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Lukas Vasquez~
 */
public class Engineer extends AbstractPlayerCharacter {


  /**
   * Creates a new engineer.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  public Engineer(final @NotNull String name, final int maxHp, final int defense,
      final TurnsQueue turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public String toString() {
    return "Engineer{maxHp=%d, defense=%d, name='%s'}".formatted(maxHp, defense, name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Engineer.class, name, maxHp, defense);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Engineer that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense;
  }
  
  @Override
  public void equipSword(Sword sword) throws InvalidWeaponAssignmentException {
    throw new InvalidWeaponAssignmentException();
  }
  
  @Override
  public void equipAxe(Axe axe) {
    this.equippedWeapon = axe;
  }
  
  @Override
  public void equipKnife(Knife knife) throws InvalidWeaponAssignmentException {
    throw new InvalidWeaponAssignmentException();
  }
  
  @Override
  public void equipStaff(Staff staff) throws InvalidWeaponAssignmentException {
    throw  new InvalidWeaponAssignmentException();
  
  }
  
  @Override
  public void equipBow(Bow bow) throws InvalidWeaponAssignmentException {
    this.equippedWeapon = bow;
  }
}
