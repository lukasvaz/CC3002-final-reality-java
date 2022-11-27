package cl.uchile.dcc.finalreality.model.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;


/**
 * This represents a Factory for WhiteMage´s creation.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public class BlackMageFactory extends AbstractMageFactory {
 
  @Override
 public PlayerCharacter create(TurnsQueue queue) {
    return new BlackMage(super.name, super.maxHp, super.defense, super.maxMp, queue);
  }
}
