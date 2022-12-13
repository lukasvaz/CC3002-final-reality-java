package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.effects.EffectsInterface;
import cl.uchile.dcc.finalreality.view.ViewInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public  abstract class AbstractState implements StateInterface {
  
  public void updateState(Controller c){}
  
  public void createCharacter(Controller controller)  {
  }
  
  public  void selectCharacters(Controller controller){}
 
  public void createEnemy(Controller controller)  {
  }
  public void Attack(Controller controller)  {}
  public void magicAttack(Controller controller)  {
  }
  public void selectWeapon(Controller controller)  {
  }
 
  public void initTurn(Controller controller)  {
  }
  
  public void characterTurn(Controller controller) {
  }
  
  public void enemyTurn(Controller controller)  {
  }
  
  public void end(Controller controller) {}
  public void magicCharacterTurn(Controller controller) {}
  
  @Override
  public void action(Controller c) throws NullWeaponException, InvalidWeaponAssignmentException, WeaponNotInInventoryException, IOException {
  
  }
  
  @Override
  public void selectCharacterMove(String s, Controller c) {
  
  }
  
  @Override
  public void selectEnemyMove(String s, Controller c) {
  
  }
  
  @Override
  public void selectEnemy(Controller c) {
  
  }
  @Override
  public void selectMagic(Controller c) {
  
  }
  @Override
  public void selectWeaponMove(String s, Controller c) throws InvalidWeaponAssignmentException, WeaponNotInInventoryException {
  
  }
  @Override
  public void chooseMove(String s, Controller c) {
  
  }
  public boolean isEnd(Controller controller) {
   return false;
  }
 
  public boolean isEnemyTurn(Controller controller) {
    return false;
  }
  

  
}