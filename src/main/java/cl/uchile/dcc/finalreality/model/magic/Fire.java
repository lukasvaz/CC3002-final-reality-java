package cl.uchile.dcc.finalreality.model.magic;

import cl.uchile.dcc.finalreality.exceptions.NotEnughMpException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerMage;
import cl.uchile.dcc.finalreality.model.effects.Burned;
import java.util.Random;

/**
 * *
 * This class instantiates  Fire Magic type.
 *
 */
public class Fire extends BlackMagic {
  Random random = new Random();
 
  public void setSeed(int x) {
    this.random = new Random(x);
  }
  /**
  * This method declares the effects asociated to Fire usage.
  */
  
  public void magicOn(GameCharacter m, GameCharacter g) throws NotEnughMpException {
    if (((PlayerMage) m).getcurrentMp() >= 15) {
      int points = Math.max(g.getCurrentHp() - ((PlayerMage)m).getEquippedWeapon().magicAttack(),
              0);
      g.setCurrentHp(points);
      int mpPoints = ((PlayerMage)m).getcurrentMp() - 15;
      ((PlayerMage) m).setCurrentMp(mpPoints);
      int num = random.nextInt(1, 100);
      if (num <= 20) {
        Burned b=new Burned();
        b.setAssociatedDmg(m.getAttack()/2);
        ((Enemy) g).setEffect(b);
      }
    } else {
      throw new NotEnughMpException();
    }
  }
  
  
}
