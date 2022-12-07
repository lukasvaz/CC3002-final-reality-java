package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.character.Enemy;

/**
 * This class represents poisoned state.
 *
 * @author ~Lukas Vasquez~
 * */

public class Poisoned implements  EffectsInterface {
  int asociatedDmg;
 static Poisoned uniqueInstance;
  
  /**
   * This method gurantee that the instance of Burned effect is unique.
   *
   * @author ~Lukas Vasquez~
   * */
  
  public static Poisoned uniqueInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new Poisoned();
    }
    return  uniqueInstance;
  }
  
  @Override
  public void updateEffect(Enemy e) {
    e.setCurrentHp(e.getCurrentHp() - this.asociatedDmg);
  }
  
  public void setAsociatedDmg(int dmg) {
    this.asociatedDmg=dmg;
  }
}
