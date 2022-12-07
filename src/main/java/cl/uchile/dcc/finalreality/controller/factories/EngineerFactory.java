package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;

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
