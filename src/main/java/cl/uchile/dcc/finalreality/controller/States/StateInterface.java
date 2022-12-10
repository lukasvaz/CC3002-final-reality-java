package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;

public interface StateInterface {

  void selectCharacters(Controller controller) ;
 
  void createEnemy(Controller controller) ;
 
  void initTurn(Controller controller) ;
  
  void characterTurn(Controller controller) ;
  
  void enemyTurn(Controller controller) ;
  
  void end(Controller controller) ;
  

 
  void action(Controller c) throws NullWeaponException, InvalidWeaponAssignmentException, WeaponNotInInventoryException;
  
}
