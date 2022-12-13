package cl.uchile.dcc.finalreality.model.effects;
import cl.uchile.dcc.finalreality.model.character.Enemy;

/**
 * This class represents poisoned state.
 *
 * @author ~Lukas Vasquez~
 * */

public class Poisoned implements  EffectsInterface {
  int associatedDmg;
 
 
  public void addTo(Enemy e) {
    e.getEffects().add(0,this);
  }
 
  public void applyEffect(Enemy e) {
    e.setCurrentHp(e.getCurrentHp() - this.associatedDmg);
  }
  
  @Override
  public int getAssociatedDamage() {
    return this.associatedDmg;
  }
  
  
  public void setAssociatedDmg(int dmg) {
    this.associatedDmg = dmg;
  }
  

}
