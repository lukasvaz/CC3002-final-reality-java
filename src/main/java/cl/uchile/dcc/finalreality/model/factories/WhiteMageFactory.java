package cl.uchile.dcc.finalreality.model.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;


/**
 * This represents a Factory for WhiteMage´s creation.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public class WhiteMageFactory extends AbstractMageFactory {
 
  @Override
 public WhiteMage create(TurnsQueue queue) {
    return new WhiteMage(super.name, super.maxHp, super.defense, super.maxMp, queue);
  }
}
