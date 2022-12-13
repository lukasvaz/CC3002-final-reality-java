package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;

public class Attack extends AbstractState {
 @Override
 public void action(Controller c) throws NullWeaponException {
  try {
      c.attack(c.getActiveCharacter() , c.getTarget());
      c.getView().showAttack(c.getActiveCharacter(), c.getTarget());
      c.getTarget().notifyDmg();
      c.getTarget().show();
     
      if (c.doesPlayerWin()) {
       c.getState().end(c);
      } else {
        c.sendToQueue(c.getActiveCharacter());
        c.getState().initTurn(c);}
  } catch (NullWeaponException n) {
      c.getView().showNullWeaponExceptionMsg(c.getActiveCharacter());
      c.getState().selectEnemy(c);
    }
  }
 
 public void updateState(Controller c) {
    if(c.getUserInput().equals("Attack")) {
        c.getState().Attack(c);
    }
  }
 
 public void initTurn(Controller c) {
    c.setState(new initTurn());
  }
 
 public void selectEnemy(Controller c) {
    c.setState(new selectEnemy());
  }
  
 public void end(Controller c) {
  c.setState(new End());
 }
}
