package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class selectEnemy extends AbstractState{
 ArrayList<String> validInputs=new ArrayList ( Arrays.asList("Magic","Attack","MagicAttack","Enemy","Weapon"));
 
 @Override
 public void action(Controller c) throws NullWeaponException, InvalidWeaponAssignmentException, WeaponNotInInventoryException, IOException {
  
  c.getView().askForEnemy(c.getEnemies());
  c.getView().showOptions();
  c.getPlayer().move(c);
  while (!this.validInputs.contains(c.getUserInput())) {
      try {
        c.setTarget(c.getEnemies().get(Integer.parseInt(c.getUserInput())));
      } catch (NumberFormatException i) {
        c.getView().showInvalidEnemyMsg();
      }
      c.getView().askForEnemy(c.getEnemies());
      c.getView().showOptions();
      c.getPlayer().move(c);
    }
    c.getInputListener().listenInput(c);
 }
 public void updateState(Controller c) {
  if(c.getUserInput().equals("Enemy")){
   c.getState().selectEnemy(c);
  }
 }
 
 public void Attack(Controller c) {
  c.setState(new Attack());
 }
 
 public void selectMagic(Controller c) {
  c.setState(new SelectMagic());
 }
 
 public void selectWeapon(Controller c) {
  c.setState(new SelectWeapon());
 }
 
 public void magicAttack(Controller c) {
  c.setState(new MagicAttack());
 }
 
}
