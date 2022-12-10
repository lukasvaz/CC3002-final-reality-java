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
  
  @Override
  public void addTo(Enemy e) {
    e.getEffects().add(0, this);
  }
  
  
  public void setAssociatedDmg(int associatedDmg) {
    this.associatedDmg = associatedDmg;
  }
  
  /**
  * This method implements the actions asociated to the effect.In this case
  * Burned does send the character to the queue.
  *
  * @author ~Lukas Vasquez~
  * */
 
  public void applyEffect(Enemy e) {
    System.out.println(e.getCurrentHp());
    System.out.println(associatedDmg);
    e.setCurrentHp(e.getCurrentHp() - this.associatedDmg);
  }
}
