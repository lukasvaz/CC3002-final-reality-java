package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import org.jetbrains.annotations.NotNull;

/**
 *An abstract class that holds the common behaviour of all the characters in the game.
 *
 *@author <a href="https://www.github.com/r8vnhill">R8V</a>
 *@author ~Lukas Vasquez~
 */
public abstract class AbstractCharacter implements GameCharacter {

  private int currentHp;
  protected int maxHp;
  protected int defense;
  protected final TurnsQueue turnsQueue;
  protected final String name;
  

  /**
   * Creates a new character.
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
  protected AbstractCharacter(@NotNull String name, int maxHp, int defense,
      TurnsQueue turnsQueue) throws InvalidStatValueException {
    Require.statValueAtLeast(1, maxHp, "Max HP");
    Require.statValueAtLeast(0, defense, "Defense");
    this.maxHp = maxHp;
    this.currentHp = maxHp;
    this.defense = defense;
    this.turnsQueue = turnsQueue;
    this.name = name;
  }

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.push(this);
  }

  /**
   * returns the character's name.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Returns the character's current Hp points.
   */
  @Override
  public int getCurrentHp() {
    return currentHp;
  }
  /**
   * Returns the limit of hp points that this character could have.
   */

  @Override
  public int getMaxHp() {
    return maxHp;
  }
  /**
   * Returns the Defense points.
   */

  @Override
  public int getDefense() {
    return defense;
  }

  /**
   *Set the Hp points.
   */
  @Override
  public void setCurrentHp(int hp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, hp, "Current HP");
    Require.statValueAtMost(maxHp, hp, "Current HP");
    currentHp = hp;
  }
}
