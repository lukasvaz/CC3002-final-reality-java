package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;

public class EnemyTurn extends AbstractState{
 @Override
 public void action(Controller c) throws NullWeaponException, InvalidWeaponAssignmentException, WeaponNotInInventoryException {
    c.setRandomCharacterTarget();
    c.attack(c.getActiveCharacter(),c.getTarget());
    c.getTarget().notifyDmg();
    c.getView().showAttack(c.getActiveCharacter(), c.getTarget());
    c.getView().showCharacter(c.getTarget().getName(),c.getTarget().getCurrentHp(),
            c.getTarget().getDefense(),c.getSelectedWeapon());
    
    c.setActiveCharacter(null);
    
  if (c.doesEnemiesWin()) {
      c.getState().end(c);
    } else {
      c.getState().initTurn(c);
    }
  }
 
  @Override
 public void end(Controller c) {
    c.setState(new End());
  }
 @Override
  public void initTurn(Controller c) {
    c.setState(new initTurn());
  }
}
