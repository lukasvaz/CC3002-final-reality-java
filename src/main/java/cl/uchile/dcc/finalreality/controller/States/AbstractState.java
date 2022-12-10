package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.view.ViewInterface;

public  abstract class AbstractState implements StateInterface {
 

  
  public void createCharacter(Controller controller)  {
  }
  
  public  void selectCharacters(Controller controller){}
 
  public void createEnemy(Controller controller)  {
  }
 
  public void initTurn(Controller controller)  {
  }
  
  public void characterTurn(Controller controller) {
  }
  
  public void enemyTurn(Controller controller)  {
  }
  
  public void end(Controller controller) {
  }
  
  public boolean isEnd(Controller controller) {
   return false;
  }
 
  public boolean isEnemyTurn(Controller controller) {
    return false;
  }
}