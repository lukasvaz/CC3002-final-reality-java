/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.States.CharacterTurn;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * <p>All player characters have a {@code name}, a maximum amount of <i>hit points</i>
 * ({@code maxHp}), a {@code defense} value, a queue of {@link GameCharacter}s that are
 * waiting for their turn ({@code turnsQueue}), and can equip a {@link Weapon}.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Lukas Vasquez~
 */
public abstract class AbstractPlayerCharacter  extends AbstractCharacter implements
    PlayerCharacter {
  protected ScheduledExecutorService scheduledExecutor;
  protected Weapon equippedWeapon = null;

  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
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
  protected AbstractPlayerCharacter(@NotNull final String name, final int maxHp,
      final int defense, @NotNull final TurnsQueue turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }
  /**
   * Equips a weapon to the character.
   */
  
  @Override
  public void equip(Weapon weapon) throws InvalidWeaponAssignmentException {
    weapon.equippedby(this);
  }
  
  @Override
  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }
  
  /**
   * get the attack points for this character.
   */
  @Override
  public int getAttack() {
    return this.getEquippedWeapon().getDamage();
  }
  

  
  @Override
  public void waitTurn() throws NullWeaponException {
    try {
      scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
  
      scheduledExecutor.schedule(
              /* command = */ this::addToQueue,
              /* delay = */ this.getEquippedWeapon().getWeight() / 10,
              /* unit = */ TimeUnit.SECONDS);
     
      scheduledExecutor.shutdown();
    
    } catch (Exception e) {
      throw new NullWeaponException();
    }
  }
  

  @Override
  public void dead() {
    this.controller.getCharacters().remove(this);
    this.controller.getQueue().get_queue().remove(this);
  }
  
  
}


