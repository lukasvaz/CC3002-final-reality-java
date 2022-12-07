package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Knight;


/**
 * This represents a Factory for creating Knights.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public class KnightFactory extends AbstractFactory {
  
  KnightFactory uniqueInstance;
  
  /**
   * This method guarantee an unique instance if this factory (Singleton Pattern).
   *
   * @author ~Lukas Vasquez Verdejo~
   */
  public KnightFactory  uniqueInstance() {
    if (this.uniqueInstance == null) {
      this.uniqueInstance = new KnightFactory();
    }
    return  this.uniqueInstance;
    
  }
 
  @Override
  public Knight create(TurnsQueue queue) {
    return new Knight(super.name, super.maxHp, super.defense, queue);
  }
}
