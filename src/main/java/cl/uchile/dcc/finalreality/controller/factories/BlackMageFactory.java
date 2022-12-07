package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;


/**
 * This represents a Factory for WhiteMage´s creation.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public class BlackMageFactory extends AbstractMageFactory {
 
  @Override
 public BlackMage create(TurnsQueue queue) {
    return new BlackMage(super.name, super.maxHp, super.defense, super.maxMp, queue);
  }
}
