package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;

import java.io.IOException;

public class SelectMagic extends AbstractState {

 
 public void action(Controller c) throws IOException {
    c.getView().askForMagic(c.getMagicArray());
    c.getView().showOptions();
    c.getPlayer().move(c);
  while (!c.getInputListener().isValidInput(c.getUserInput())) {
   try {
    c.setMagic(c.getMagicArray().get(Integer.parseInt(c.getUserInput())));
   } catch (NumberFormatException|IndexOutOfBoundsException i) {
    c.getView().showInvalidMagicMsg();
   }
   c.getView().askForMagic(c.getMagicArray());
   c.getView().showOptions();
   c.getPlayer().move(c);
  }
  c.getInputListener().listenInput(c);
 }
 
 
 
 public void updateState(Controller c) {
   if(c.getUserInput().equals("Magic")) {
      c.getState().selectMagic(c);
   }
  }
  
 public void selectMagic(Controller c) {
  c.setState(new SelectMagic());
  }
 public void selectWeapon(Controller c) {
  c.setState(new SelectWeapon());
 }
 public void Attack(Controller c) {
  c.setState(new Attack());
 }
 public void selectEnemy(Controller c) {
  c.setState(new selectEnemy());
 }
 public void magicAttack(Controller c) {
  c.setState(new MagicAttack());
 }
 
}
