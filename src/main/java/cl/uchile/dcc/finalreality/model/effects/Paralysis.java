package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.character.Enemy;

/**
 * This class represents paralysis state.
 *
 * @author ~Lukas Vasquez~
 * */

public class Paralysis implements EffectsInterface {
  private static Paralysis uniqueInstance;
 
  /**
  * This method restricts that the instance of a Paralysis effect is unique.
  *
  * @author ~Lukas Vasquez~
  * */
 
  public static Paralysis uniqueInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new Paralysis();
    }
    return  uniqueInstance;
  }
 
  /**
  * This method implements the actions asociated to the effect.In this case
  * Paralysis sends inmediately the character to the queue.
  *
  * @author ~Lukas Vasquez~
  * */
 
  public void updateEffect(Enemy e) {
    e.setEffect(NullEffect.uniqueInstance());
    e.waitTurn();
  }
}
