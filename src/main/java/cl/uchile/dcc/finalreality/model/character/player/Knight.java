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
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can equip {@code Sword}s,{@code Knife}s and
 * {@code Axe}s.
 */
public class Knight extends NonMagicCharacters {

  /**
   * Creates a new Knight.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's maximum health points
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  public Knight(@NotNull final String name, int maxHp, int defense,
      @NotNull final TurnsQueue turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }
  
  @Override
  public String toString() {
    return "Knight{maxHp=%d, defense=%d, name='%s'}".formatted(maxHp, defense, name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Knight.class, name, maxHp, defense);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Knight that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense;
  }
  
  @Override
  public void equipSword(Sword sword)  {
    this.equippedWeapon = sword;
  }
  
  @Override
  public void equipAxe(Axe axe)  {
    this.equippedWeapon = axe;
  }
  
  @Override
  public void equipKnife(Knife knife)  {
    this.equippedWeapon = knife;
  }
  
  @Override
  public void equipStaff(Staff staff) throws InvalidWeaponAssignmentException {
    throw  new InvalidWeaponAssignmentException();
  }
  
  @Override
  public void equipBow(Bow bow) throws InvalidWeaponAssignmentException {
    throw  new InvalidWeaponAssignmentException();
  }
}
