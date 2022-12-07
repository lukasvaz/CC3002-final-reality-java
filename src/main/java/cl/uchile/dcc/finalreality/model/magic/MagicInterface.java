package cl.uchile.dcc.finalreality.model.magic;


import cl.uchile.dcc.finalreality.exceptions.NotEnughMpException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerMage;

/**
 * This interface .
 */
public interface MagicInterface {

  boolean isImplentedBy(PlayerMage m);
 
  void magicOn(GameCharacter m, GameCharacter g) throws NotEnughMpException;
  
  void nonMagicCharacterOn(GameCharacter atacker, GameCharacter reciever)
          throws NotImplementsMagicException;
  
  void enemyOn(GameCharacter atacker, GameCharacter reciever)
          throws NotImplementsMagicException;
  
  void whiteMageOn(GameCharacter atacker, GameCharacter reciever)
          throws NotImplementsMagicException, NotEnughMpException;
  
  void blackMageOn(GameCharacter atacker, GameCharacter reciever)
          throws NotImplementsMagicException, NotEnughMpException;
}
