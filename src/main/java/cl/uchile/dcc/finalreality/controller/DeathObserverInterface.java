package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * This interface represent a set of behaviors of an observer class which
 * manages character´s death process.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Lukas Vasquez~
 */

public interface DeathObserverInterface {
 
  void updateDeaths(GameCharacter charcter);
  
}
