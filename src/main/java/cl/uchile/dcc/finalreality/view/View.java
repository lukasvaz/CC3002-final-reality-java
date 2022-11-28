package cl.uchile.dcc.finalreality.view;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

/**
 * Class which manages the interaction with user.
 */

public class View {
 
  Controller controller = new Controller();
  String userInput;
 
  /**
  *Getter for controller atribute.
  */
  public Controller getController() {
    return this.controller;
  }
 
  /**
  *Main Example method.
  */
  public static void main(String[] args) {
    View view = new View();
    Controller c = view.getController();
    while (!c.isMaxCharacters()) {
      c.askForSingleCharacter();
      for (PlayerCharacter ch : c.getCharacters()) {
        System.out.println(ch);
      }
    }
    System.out.println("versus\nEnemies:");
    for (int i = 0; i <= 6; i++) {
      c.createEnemy(c.getQueue());
      System.out.println(c.getEnemies().get(i));
    }
    System.out.println("end");
  }
}
