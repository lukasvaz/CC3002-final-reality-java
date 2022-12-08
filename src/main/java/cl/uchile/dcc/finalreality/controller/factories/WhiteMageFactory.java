package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;


/**
 * This represents a Factory for WhiteMage´s creation.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public class WhiteMageFactory extends AbstractFactory {
  int maxMp = 250;
  
  @Override
 public WhiteMage create(TurnsQueue queue) {
    return new WhiteMage(super.name, super.maxHp, super.defense, this.maxMp, queue);
  }
 
 
  public void setMaxMp(int maxMp) {
    this.maxMp = maxMp;
  }
}
