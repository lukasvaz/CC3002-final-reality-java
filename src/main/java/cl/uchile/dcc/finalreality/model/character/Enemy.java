package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.States.EnemyTurn;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.effects.EffectsInterface;
import cl.uchile.dcc.finalreality.model.effects.EffectsObservable;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cl.uchile.dcc.finalreality.model.effects.Paralysis;
import cl.uchile.dcc.finalreality.model.magic.MagicInterface;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Lukas Vasquez~
 */

public class Enemy extends AbstractCharacter implements EffectsObservable {
  
  private ArrayList<EffectsInterface> effects;
  int paralyseCounter;
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
    this.paralyseCounter = 0;
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
  
  @Override
  public void dead() {
    this.controller.getEnemies().remove(this);
    this.controller.getQueue().get_queue().remove(this);
  }
  
  @Override
  public void selectTurn() {
    this.controller.getState().enemyTurn(this.controller);
  }
  
  /**
   * Returns enemy's Effect state .
   */
  
  public ArrayList<EffectsInterface> getEffects() {
    return this.effects;
  }
  
  /**
   * Returns enemy Paralyses states.
   */
  
  public int getParalyseCounter() {
    return this.paralyseCounter;
  }
  
  public void setParalyseCounter(int i) {
    this.paralyseCounter=i;
  }
  public boolean isAnyEffect(EffectsInterface effect) {
   
    for (EffectsInterface e : this.getEffects()) {
      System.out.println(e.getClass());
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
    effect.addTo(this);
  }
  
  /**
   * Update Effect states of a character .
   */
  @Override
  public void notifyEffects() throws InterruptedException, NullWeaponException {
    //no pude  dejar todos los efectos en un arreglo ,pues como al aplicar paralysis esta se elimina de la lista
    // de efectos me tira un Concurrent error (elimino un elemento de la lista en la que itero),
    // el funcionamiento es el que se quiere  pues solo se ejecuta un Paralysis si es que el contador>0
  
    for (EffectsInterface e : this.getEffects()) {
        e.applyEffect(this);
    }
    Paralysis.uniqueInstance().applyEffect(this);
  }
  
  
}
