package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SelectWeapon extends AbstractState {
 ArrayList<String> validInputs=new ArrayList ( Arrays.asList("Magic","Attack","MagicAttack","Enemy","Weapon"));
 
 public void action(Controller c) throws IOException {
   c.getView().askForInventaryWeapon(c);
   c.getView().showOptions();
   c.getPlayer().move(c);
   while (!this.validInputs.contains(c.getUserInput())) {
    try {
     c.setSelectedWeapon(c.getInventary().get(Integer.parseInt(c.getUserInput())));
     ((PlayerCharacter) c.getActiveCharacter()).equip(c.getSelectedWeapon());
     c.getView().showWeaponEquipment(c.getActiveCharacter(),c.getSelectedWeapon());
    } catch (NumberFormatException|IndexOutOfBoundsException i) {
     c.getView().showInvalidWeaponMsg();
    } catch (InvalidWeaponAssignmentException e) {
     c.getView().showInvalidWeaponAssignmentException(c.getActiveCharacter(),c.getSelectedWeapon());
    }
    c.getView().askForInventaryWeapon(c);
    c.getView().showOptions();
    c.getPlayer().move(c);
    }
  c.getInputListener().listenInput(c);
 }
 
  public void updateState(Controller c) {
     if(c.getUserInput().equals("Weapon")) {
      c.getState().selectWeapon(c);
     }
  }
  
 public void Attack(Controller c) {
  c.setState(new Attack());
 }
 
 public void selectMagic(Controller c) {
  c.setState(new SelectMagic());
 }
 public void selectEnemy(Controller c) {
  c.setState(new selectEnemy());
 }
 public void magicAttack(Controller c) {
  c.setState(new MagicAttack());
 }
 
}
