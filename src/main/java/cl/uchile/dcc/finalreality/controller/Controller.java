package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.factories.*;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controller which drives the logic of the game.
 */
public class Controller {
  private  ArrayList<PlayerCharacter> characters;
  private  ArrayList<PlayerCharacter> enemies;
  private  TurnsQueue queue;
  private  int  maxCharacters = 5;
  private IFactory factory;
  private GameCharacter gc;
  /**
   * A template method to ask the user  which character will use.
   */
  
  public  Controller() {
    this.characters = new ArrayList<>();
    this.enemies = new ArrayList<>();
    this.queue = new TurnsQueue();
  }
  
  public void askForSingleCharacter() {
    System.out.println("Type your character:\n Options: Engineer | BlackMage | Knight | Thief | WhiteMage");
    Scanner sc = new Scanner(System.in); //System.in is a standard input stream
    String str = sc.nextLine();             //reads string
    if (str.equals("Engineer")) {
      System.out.println("Creating Engineer\nChoose a name:");
      String name = sc.nextLine();
      this.factory = new EngineerFactory();
      this.factory.setName(name);
      this.factory.setDefense(80);
      this.factory.setMaxHp(200);
      this.characters.add(this.factory.create(this.queue));
      
    }
    if (str.equals("BlackMage")) {
      System.out.println("Creating BlackMage\nChoose a name:");
      String name = sc.nextLine();
      this.factory = new BlackMageFactory();
      this.factory.setName(name);
      this.factory.setDefense(70);
      this.factory.setMaxHp(200);
      IMageFactory fac = (IMageFactory) this.factory;
      fac.setMaxMp(150);
      this.characters.add(this.factory.create(this.queue));
  
    }
    if (str.equals("Knight")) {
      System.out.println("Creating Knight\nChoose a name:");
      String name = sc.nextLine();
      this.factory = new KnightFactory();
      this.factory.setName(name);
      this.factory.setDefense(100);
      this.factory.setMaxHp(200);
      this.characters.add(this.factory.create(this.queue));
      
    }
    if (str.equals("Thief")) {
      System.out.println("Creating Thief\nChoose a name:");
      String name = sc.nextLine();
      this.factory = new ThiefFactory();
      this.factory.setName(name);
      this.factory.setDefense(70);
      this.factory.setMaxHp(150);
      this.characters.add(this.factory.create(this.queue));
    }
    if (str.equals("WhiteMage")) {
      System.out.println("Creating WhiteMage\nChoose a name:");
      String name = sc.nextLine();
      this.factory = new BlackMageFactory();
      this.factory.setName(name);
      this.factory.setDefense(50);
      this.factory.setMaxHp(180);
      IMageFactory fac=(IMageFactory) this.factory;
      fac.setMaxMp(300);
      this.characters.add(this.factory.create(this.queue));
  
    }
  }
  
  public void selectCharacter(PlayerCharacter p) {
   this.view
    this.factory
  }
  
  public static void main(String[] args) {
    Controller c = new Controller();
    while (c.characters.size()!= c.maxCharacters){
      c.askForSingleCharacter();
      for (PlayerCharacter ch: c.characters){
        System.out.println(ch);
      }
      c.characters.size();}
    System.out.println("end");
  }

}
