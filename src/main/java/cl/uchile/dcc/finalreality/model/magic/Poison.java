package cl.uchile.dcc.finalreality.model.magic;

import cl.uchile.dcc.finalreality.exceptions.NotEnughMpException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerMage;
import cl.uchile.dcc.finalreality.model.effects.Burned;
import cl.uchile.dcc.finalreality.model.effects.Poisoned;
/**
 * This class represents the use of Poison Magic.
 */

public class Poison extends WhiteMagic implements MagicInterface  {
  /**
   * This method declares the effects asociated to Heal usage.
   */
  public void magicOn(GameCharacter m, GameCharacter g) throws NotEnughMpException, NullWeaponException {
    if (((PlayerMage) m).getcurrentMp() >= 15) {
      int mpPoints = Math.max(((PlayerMage) m).getcurrentMp() - 40, 0);
      ((PlayerMage) m).setCurrentMp(mpPoints);
      Poisoned p = new Poisoned();
      p.setAssociatedDmg(m.getMagicAttack());
      ((Enemy) g).setEffect(p);
    } else {
      throw new NotEnughMpException();
    }
  }
  
  @Override
  public void setSeed(int i) {
  
  }
  
}
