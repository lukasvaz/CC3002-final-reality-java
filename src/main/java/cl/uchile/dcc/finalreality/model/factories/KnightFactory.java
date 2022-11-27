package cl.uchile.dcc.finalreality.model.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;


/**
 * This represents a Factory for creating Knights.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public class KnightFactory extends AbstractFactory {
  
 
  @Override
  public PlayerCharacter create(TurnsQueue queue) {
    return new Knight(super.name, super.maxHp, super.defense, queue);
  }
}
