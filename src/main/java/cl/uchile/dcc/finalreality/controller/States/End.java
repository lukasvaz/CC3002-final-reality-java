package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;

import java.io.IOException;

public class End extends AbstractState {
  @Override
  public void action(Controller c) throws NullWeaponException, InvalidWeaponAssignmentException, WeaponNotInInventoryException, IOException {
   if (c.doesPlayerWin()){
     c.getView().showCharactersWin();
   } else{
    c.getView().showEnemiesWin();
   }
  }
}
