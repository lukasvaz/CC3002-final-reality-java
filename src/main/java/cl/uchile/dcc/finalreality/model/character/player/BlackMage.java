/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.magic.MagicInterface;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * A Black Mage is a type of player character that can cast black magic.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Lukas Vasquez~
 * @version 2.0
 */
public class BlackMage extends AbstractMage {
  /**
   * Creates a new Black Mage.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param maxMp
   *         the character's limit of Mana Points.
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */

  public BlackMage(final @NotNull String name,  final int defense, final int maxHp,
                   int maxMp, final @NotNull TurnsQueue turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, maxMp, turnsQueue);
    Require.statValueAtLeast(0, maxMp, "Max MP");
  }
  
 
  
  // region : UTILITY METHODS
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final BlackMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense
        && maxMp == that.maxMp;
  }

  @Override
  public String toString() {

    return "BlackMage{currentMp=%d, maxMp=%d, maxHp=%d, defense=%d, name='%s'}"
        .formatted(getcurrentMp(), getmaxMp(), maxHp, defense, name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(BlackMage.class, name, maxHp, defense, maxMp);
  }
  
  @Override
  public void equipSword(Sword sword) throws InvalidWeaponAssignmentException {
    throw new InvalidWeaponAssignmentException();
  }
  
  @Override
  public void equipAxe(Axe axe) throws InvalidWeaponAssignmentException {
    throw new InvalidWeaponAssignmentException();
  }
  
  @Override
  public void equipKnife(Knife knife) {
    this.equippedWeapon = knife;
  }
  
  @Override
  public void equipStaff(Staff staff) {
    this.equippedWeapon = staff;
  }
  
  @Override
  public void equipBow(Bow bow) throws InvalidWeaponAssignmentException {
    throw new InvalidWeaponAssignmentException();
  }
  
  public boolean implementsWhiteMagic() {
    return false;
  }
  

  public boolean implementsBlackMagic() {
    return true;
  }
  
  @Override
  public void implementsMagic(MagicInterface magic, GameCharacter character) throws NotImplementsMagicException, NotEnughMpException {
    magic.blackMageOn(this, character);
  }
}
