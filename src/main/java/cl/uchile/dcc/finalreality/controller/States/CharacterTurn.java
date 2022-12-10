package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;

public class CharacterTurn extends  AbstractState{
 @Override
 public void action(Controller c) throws NullWeaponException, InvalidWeaponAssignmentException, WeaponNotInInventoryException {
 
 }
}
