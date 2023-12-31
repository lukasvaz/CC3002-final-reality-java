package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.weapon.Staff;

/**
 * On this class we will test all the methods  of this project.
 */
public class Main {
  public static void main(String[] args) throws InvalidStatValueException, NullWeaponException {
    TurnsQueue queue=new TurnsQueue();
    Knight knight=new Knight("nombre",10,90,queue);
    knight.waitTurn();
   
  }
}
