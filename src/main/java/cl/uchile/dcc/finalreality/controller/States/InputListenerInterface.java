package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;

public interface InputListenerInterface {
 
 public void listenInput(Controller c);
 boolean  isValidInput(String s);
}
