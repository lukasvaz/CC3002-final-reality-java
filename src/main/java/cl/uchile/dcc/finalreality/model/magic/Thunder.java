package cl.uchile.dcc.finalreality.model.magic;

import cl.uchile.dcc.finalreality.exceptions.NotEnughMpException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerMage;
import cl.uchile.dcc.finalreality.model.effects.Paralysis;
import java.util.Random;

/**
 * This class instantiates  Thunder Magic type.
 */

public class Thunder extends BlackMagic {
  
  Random random = new Random();
  
  public void setSeed(int x) {
    this.random = new Random(x);
  }
  
  /**
  * This method declares the effects asociated to Thunder usage.
  */
  public void magicOn(GameCharacter m, GameCharacter g) throws NotEnughMpException, NullWeaponException {
    if (((PlayerMage) m).getcurrentMp() >= 15) {
      int points = Math.max(g.getCurrentHp() - m.getMagicAttack() , 0);
      g.setCurrentHp(points);
      ((PlayerMage) m).setCurrentMp(((PlayerMage) m).getcurrentMp() - 15);
      int num = random.nextInt(1, 100);
      if (num <= 30) {
        ((Enemy) g).setParalyseCounter(((Enemy) g).getParalyseCounter()+1);
      }
    }  else {
      throw new NotEnughMpException();
    }
    
  }
  
}
