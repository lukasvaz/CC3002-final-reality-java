package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.character.Enemy;

/**
 * This class represents  Burned state.
 *
 * @author ~Lukas Vasquez~
 * */
public class Burned implements EffectsInterface {
  int associatedDmg;
  private static Burned uniqueInstance;
 
  /**
  * This method gurantee that the instance of Burned effect is unique.
  *
  * @author ~Lukas Vasquez~
  * */
 
  public static Burned uniqueInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new Burned();
    }
    return  uniqueInstance;
  }
 
  /**
  * This method implements the actions asociated to the effect.In this case
  * Burned does send the character to the queue.
  *
  * @author ~Lukas Vasquez~
  * */
 
  public void updateEffect(Enemy e) {
    e.setCurrentHp(e.getCurrentHp() - this.associatedDmg);
  }
}
