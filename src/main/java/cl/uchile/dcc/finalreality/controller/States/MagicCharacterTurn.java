package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;

import java.io.IOException;

public class MagicCharacterTurn extends AbstractState{
  @Override
 public void action(Controller c) throws NullWeaponException, InvalidWeaponAssignmentException, WeaponNotInInventoryException, IOException {
    do {
      c.getView().askAction();
      c.getPlayer().move(c);
    } while (!c.getUserInput().equals("Magic") & !c.getUserInput().equals("Attack"));
    
    if (c.getUserInput().equals("Magic")) {
      System.out.println("Magia");
    }
 
   if (c.getUserInput().equals("Attack")) {
    System.out.println("Attack");
   }
  }
 
 
}
