package cl.uchile.dcc.finalreality.model.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

/**
 * This represents a Factory for  Engineers creation.
 *
 * @author ~Lukas Vasquez Verdejo~
 */
public class EngineerFactory extends AbstractFactory {
  @Override
 public Engineer create(TurnsQueue queue) {
    return new Engineer(super.name, super.maxHp, super.defense, queue);
  }
}
