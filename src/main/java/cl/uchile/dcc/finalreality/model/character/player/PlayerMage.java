package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;

/**
 * This represents an {@link AbstractMage} from the game.
 * A character that has MP points.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Lukas Vasquez~
 */
public interface PlayerMage extends PlayerCharacter {

  /**
  * Sets the Mage's current MP.
  */
  void setCurrentMp(final int currentMp) throws InvalidStatValueException;

  /**
   * Returns the character's current MP.
   */
  int getcurrentMp();  
  /**
   * Returns the Mage's max MP.
   */
  
  int getmaxMp();
  
  /**
   * Returns True or flase depending of a mage  is BlackMage.
   */
  
  boolean implementsBlackMagic();
  
  
  
  /**
   * Returns True or flase depending of a mage  is WhiteMage.
   */
  
  boolean implementsWhiteMagic();
  
}
