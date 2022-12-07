package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
/**
 * This represents a Factory for creating characters.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public interface IFactory {
 
  GameCharacter create(TurnsQueue queue);
 
  void setMaxHp(int maxHp);
 
  void setName(String name);
  
  void setDefense(int defense);
 
}
