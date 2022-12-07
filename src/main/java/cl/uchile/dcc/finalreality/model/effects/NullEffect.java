package cl.uchile.dcc.finalreality.model.effects;


import cl.uchile.dcc.finalreality.model.character.Enemy;

/**
 * This class represents a Null effect state  in a character.
 *
 * @author ~Lukas Vasquez~
 * */

public class NullEffect implements EffectsInterface {
  private static NullEffect uniqueInstance;

  /**
   * This method restricts that the instance of a Null effect is unique.
   *
   * @author ~Lukas Vasquez~
   * */
  
  public static NullEffect uniqueInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new NullEffect();
    }
    return  uniqueInstance;
  }
  
  /**
   * This method implements the actions asociated to the effect.In this case
   * a Null effect does nothing.
   *
   * @author ~Lukas Vasquez~
   * */
  
  public void updateEffect(Enemy e) {
  }
}
