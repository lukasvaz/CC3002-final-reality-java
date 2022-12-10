package cl.uchile.dcc.finalreality.view;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.factories.IFactory;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

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
 
 
 /**
  * Show a message of the attacking action in the turn.
  */
 public void showAttack();
 
 
 /**
  * Ask to the user for an action ( wheter will use attacks or magic).
  */
 
 public void askAction();
 
 /**
  * Show a message of the magic to select.
  */
 public void showMagicOptions();
 
 /**
  * Show a message of the characters available to use.
  */
 public void showCharacters(Controller c);
 
 /**
  * Show a message of the enemies alive.
  */
 public void showEnemies(Controller c);
 
 /**
  * Show the inventary.
  */
 public void showInventary(Controller c);
 
 /**
  * Ask the user to equip a Weapon
  */
 public Weapon askForInventaryWeapon(Controller c);
 
}
