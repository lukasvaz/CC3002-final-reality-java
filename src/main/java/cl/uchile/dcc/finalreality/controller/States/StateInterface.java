package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;

import java.io.IOException;

public interface StateInterface {

  void selectCharacters(Controller controller) ;
 
  void createEnemy(Controller controller) ;
  void Attack(Controller controller) ;
 
  void initTurn(Controller controller) ;
  
  void characterTurn(Controller controller) ;
  
  void enemyTurn(Controller controller) ;
  
  void end(Controller controller) ;
  
  
  void magicCharacterTurn(Controller controller);
  
  void action(Controller c) throws NullWeaponException, InvalidWeaponAssignmentException, WeaponNotInInventoryException, IOException;
  
  void selectCharacterMove(String s, Controller c);
  void selectEnemyMove(String s, Controller c);
  void selectWeaponMove(String s, Controller c) throws InvalidWeaponAssignmentException, WeaponNotInInventoryException;
  
  void chooseMove(String line, Controller c);
 
 void updateState(Controller c);
  
  void magicAttack(Controller c);
  
  void selectWeapon(Controller c);
  
  
  void selectEnemy(Controller c);
 
 void selectMagic(Controller c);
}
