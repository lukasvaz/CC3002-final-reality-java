package cl.uchile.dcc.finalreality.view;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.factories.*;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

import java.util.Scanner;

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
  
  public void selectCharacterCreation(String s) {
    if (s.equals("Engineer")) {
      controller.setFactory(new EngineerFactory());
      controller.getFactory().setDefense(80);
      controller.getFactory().setMaxHp(200);
    }
    if (s.equals("BlackMage")) {
      controller.setFactory(new BlackMageFactory());
      controller.getFactory().setDefense(70);
      controller.getFactory().setMaxHp(200);
      IMageFactory fac = (IMageFactory) controller.getFactory();
      fac.setMaxMp(250);
    }
    
    if (s.equals("Knight")) {
      controller.setFactory(new KnightFactory());
      controller.getFactory().setDefense(100);
      controller.getFactory().setMaxHp(200);
    }
    if (s.equals("Thief")) {
      controller.setFactory(new ThiefFactory());
      controller.getFactory().setDefense(70);
      controller.getFactory().setMaxHp(150);
    }
    
    if (s.equals("WhiteMage")) {
      controller.setFactory(new WhiteMageFactory());
      controller.getFactory().setDefense(50);
      controller.getFactory().setMaxHp(180);
      IMageFactory fac = (IMageFactory) controller.getFactory();
      fac.setMaxMp(300);
    }
    if (s.equals("Enemy")) {
      controller.setFactory(new EnemyFactory());
    }
  }
  
  /**
   * This method asks for the user for the characters to use.
   */
  
  public void askForSingleCharacter() {
    System.out.println("Type your character:\n Options: Engineer | BlackMage | Knight | Thief | WhiteMage");
    Scanner sc = new Scanner(System.in); //System.in is a standard input stream
    String str = sc.nextLine();             //reads string
    this.selectCharacterCreation(str);
    System.out.println("Type a name:");
    String name = sc.nextLine();
    this.controller.getFactory().setName(name);
    this.controller.createCharacter(controller.getQueue());
  }
  /**
  *Main Example method.
  */
  
  
  public static void main(String[] args) {
    View view = new View();
    Controller c = view.getController();
    while (!c.isMaxCharacters()) {
      view.askForSingleCharacter();
      for (PlayerCharacter ch : c.getCharacters()) {
        System.out.println(ch);
      }
    }
    System.out.println("versus\nEnemies:");
    for (int i = 0; i <= 6; i++) {
      c.createRandomEnemy(c.getQueue());
      System.out.println(c.getEnemies().get(i));
    }
    System.out.println("end");
  }
}
