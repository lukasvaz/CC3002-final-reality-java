package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.effects.EffectsInterface;
import cl.uchile.dcc.finalreality.model.effects.NullEffect;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cl.uchile.dcc.finalreality.model.magic.MagicInterface;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Lukas Vasquez~
 */

public class Enemy extends AbstractCharacter {
  
  private ArrayList<EffectsInterface> effects;
  private final int attack;
  private final int weight;
  protected ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   *
   *  @param name
   *     the Enemy's name
   *   @param weight
   *     the Enemy's weight
   *   @param maxHp
   *     the character's limit of HP
   *   @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  public Enemy(@NotNull final String name, final int weight, int maxHp, int defense, int attack,
      @NotNull final TurnsQueue turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, weight, "Weight");
    this.weight = weight;
    this.attack = attack;
    this.effects = new ArrayList<>();
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Enemy enemy)) {
      return false;
    }
    return hashCode() == enemy.hashCode()
        && name.equals(enemy.name)
        && weight == enemy.weight
        && maxHp == enemy.maxHp
        && defense == enemy.defense;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, name, weight, maxHp, defense);
  }
  
  /**
   * Waits   @weight/ 10 seconds and then add the enemy to the queue.
   */
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = (Enemy) this;
    scheduledExecutor.schedule(
            /* command = */ this::addToQueue,
            /* delay = */ enemy.getWeight() / 10,
            /* unit = */ TimeUnit.SECONDS);
    
    scheduledExecutor.shutdown();
  }

  @Override
  public String toString() {
    return "Enemy{maxHp=%d,weight=%d, defense=%d, name='%s', attack=%d}".formatted(maxHp,
            weight, defense, name, attack);
  }
  
  /**
   * Returns enemy's attack points .
   */
  
  public int getAttack() {
    return this.attack;
  }
  
  @Override
  public void implementsMagic(MagicInterface magic, GameCharacter character)
          throws NotImplementsMagicException {
    magic.enemyOn(this,character);
  }
  
  /**
   * Returns enemy's Effect state .
   */
  
  public ArrayList<EffectsInterface> getEffects() {
    return this.effects;
  }
  
  
  public boolean isAnyEffect(EffectsInterface effect) {
   
    for (EffectsInterface e : this.getEffects()) {
      if (e.getClass() == effect.getClass()) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Set enemy's Effect state .
   */
  public void setEffect(EffectsInterface effect) {
    if (!isAnyEffect(effect)) {
      this.effects.add(effect);
    }
  }
  
  
  
}
