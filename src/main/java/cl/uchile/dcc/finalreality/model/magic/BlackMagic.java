package cl.uchile.dcc.finalreality.model.magic;

import cl.uchile.dcc.finalreality.exceptions.NotEnughMpException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerMage;

public abstract class BlackMagic implements MagicInterface {
 
  @Override
 public boolean isImplentedBy(PlayerMage m) {
    return m.implementsBlackMagic();
  }
 
  @Override
  public void nonMagicCharacterOn(GameCharacter atacker, GameCharacter reciever)
          throws NotImplementsMagicException {
    throw new NotImplementsMagicException();
  }
 
  public void enemyOn(GameCharacter atacker, GameCharacter reciever)
          throws NotImplementsMagicException {
    throw new NotImplementsMagicException();
  }
 
  public void whiteMageOn(GameCharacter atacker, GameCharacter reciever)
          throws NotImplementsMagicException {
    throw new NotImplementsMagicException();
  }
 
  public void blackMageOn(GameCharacter atacker, GameCharacter reciever)
          throws NotImplementsMagicException, NotEnughMpException, NullWeaponException {
    this.magicOn(atacker, reciever);
  }
 
}
