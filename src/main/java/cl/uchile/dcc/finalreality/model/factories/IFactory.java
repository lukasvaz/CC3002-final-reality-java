package cl.uchile.dcc.finalreality.model.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
/**
 * This represents a Factory for creating characters.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public interface IFactory {
 
  PlayerCharacter create(TurnsQueue queue);
 
  void setMaxHp(int maxHp);
 
  void setName(String name);
  
  void setDefense(int defense);
 
}
