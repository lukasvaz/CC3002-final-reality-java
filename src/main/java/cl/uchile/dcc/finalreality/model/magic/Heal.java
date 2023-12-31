package cl.uchile.dcc.finalreality.model.magic;

import cl.uchile.dcc.finalreality.exceptions.NotEnughMpException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerMage;
import cl.uchile.dcc.finalreality.model.effects.Paralysis;

import java.util.Random;


/**
 * *
 * This class instantiates a Thunder Magic type.
 *
 */
public class Heal extends WhiteMagic {
  Random random = new Random();
  
  public void setSeed(int x) {
    this.random = new Random(x);
  }
  
  /**
   * This method declares the effects asociated to Heal usage.
   */
  public void magicOn(GameCharacter m, GameCharacter g) throws NotEnughMpException {
    if (((PlayerMage) m).getcurrentMp() >= 15) {
      g.setCurrentHp(Math.min(g.getCurrentHp() + g.getMaxHp() * 3 / 10, g.getMaxHp()));
      ((PlayerMage) m).setCurrentMp(((PlayerMage) m).getcurrentMp() - 15);
    } else {
      throw new NotEnughMpException();
    }
    
  }
  
}


