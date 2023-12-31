package cl.uchile.dcc.finalreality.view;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.factories.IFactory;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.effects.EffectsInterface;
import cl.uchile.dcc.finalreality.model.magic.MagicInterface;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

import java.io.IOException;
import java.util.ArrayList;

public interface ViewInterface {
 
 
 
 /**
  * Set factory in Controller.
  */
 
 public IFactory askForCharacter();
 
 /**
  * Show loading message.
  */
 
 public void showLoading();
 
 /**
  * Show a message of the character who plays.
  */
 public void showTurn(GameCharacter g);
 

 public void showCharacter( String name, int currHp, int defense, Weapon weapon);
 public void showEnemy(String name, int currHp, int defense, ArrayList<EffectsInterface> effects,int paralysed);
 
 
 
 
 /**
  * Ask to the user for an action ( wheter will use attacks or magic).
  */
 
 public void askAction();
 
 /**
  * Show a message of the magic to select.
  */
 public void showMagic(ArrayList<MagicInterface> magicArray);
 
 public void askForMagic(ArrayList<MagicInterface> magicArray);
 
 
 /**
  * Show a message of the characters available to use.
  */
 public void showCharacters(ArrayList<PlayerCharacter> characters);
 
 /**
  * Show a message of the enemies alive.
  *
  * @return
  */
 public void showEnemies(ArrayList<Enemy> enemies);
 
 /**
  * Show the inventary.
  */
 public void showInventary(Controller c);
 
 /**
  * Ask the user to equip a Weapon
  */
 public void askForInventaryWeapon(Controller c) ;
 
 void showInvalidWeaponAssignmentException(GameCharacter g, Weapon w);
 void showWeaponNotInInventaryException( Weapon w);
 
 
 void askForEnemy(ArrayList<Enemy> enemies) ;
 
 void showInvalidWeaponMsg();
 
 void showInvalidEnemyMsg();
 
 void showWeaponEquipment(GameCharacter g, Weapon w);
 void showAttack(GameCharacter g, GameCharacter r);
 
 void showCharactersWin();
 
 void showEnemiesWin();
 
 void showOptions();
 
 void showInvalidMagicMsg();
 
 void showNullWeaponExceptionMsg(GameCharacter activeCharacter);
 
 void showMagicAttack(GameCharacter activeCharacter, GameCharacter target);
 
 void showNotEnoughMpExceptionMsg(GameCharacter activeCharacter);
 
 void showNotImplementsMagicExceptionMsg(GameCharacter activeCharacter);
}
