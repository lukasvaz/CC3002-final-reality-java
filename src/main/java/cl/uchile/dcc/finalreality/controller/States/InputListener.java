package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;

import java.util.ArrayList;
import java.util.Arrays;

public class InputListener implements InputListenerInterface{
 ArrayList<String> validInputs=new ArrayList ( Arrays.asList("Magic","Attack","MagicAttack","Enemy","Weapon"));

 ArrayList<StateInterface> inputListeners = new ArrayList ( Arrays.asList(new selectEnemy(), new SelectMagic()
         ,new SelectWeapon() , new Attack(), new MagicAttack()));
 
 public void listenInput(Controller c) {
  for (StateInterface i : this.inputListeners){
   i.updateState(c);
  }
 }
 public boolean  isValidInput(String s){
     return this.validInputs.contains(s);
 }
 
}
