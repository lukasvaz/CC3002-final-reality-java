package cl.uchile.dcc.finalreality.model.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
/**
 * This represents a Factory for Thiefs creation.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public class ThiefFactory extends AbstractFactory {
  @Override
 public Thief create(TurnsQueue queue) {
    return new Thief(super.name, super.maxHp, super.defense, queue);
  }
}
