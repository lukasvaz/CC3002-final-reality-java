package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
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
  private  ArrayList<Enemy> enemies;
  private  TurnsQueue queue;
  private  int  maxCharacters = 5;
  private IFactory factory;
  /**
   * A template method to ask the user  which character will use.
   */
  
  public  Controller() {
    this.characters = new ArrayList<>();
    this.enemies = new ArrayList<>();
    this.queue = new TurnsQueue();
  }
  /**
   * A getter for the controller's factory.
   */
  
  public IFactory getFactory() {
    return this.factory;
  }
  /**
   * A getter for the controller's queue.
   */
  
  public TurnsQueue getQueue() {
    return this.queue;
  }
  
  /**
   * A getter for the controller's characters Array.
   */
  public ArrayList<PlayerCharacter> getCharacters() {
    return this.characters;
  }
  /**
   * A getter for the controller's characters Array.
   */
  
  public ArrayList<Enemy> getEnemies() {
    return this.enemies;
  }
  /**
   * This method asks for the user for the characters to use.
   */
  
  public void askForSingleCharacter() {
    System.out.println("Type your character:\n Options: Engineer | BlackMage | Knight | Thief | WhiteMage");
    Scanner sc = new Scanner(System.in); //System.in is a standard input stream
    String str = sc.nextLine();             //reads string
    this.selectCharacter(str);
    System.out.println("Type a name:");
    String name = sc.nextLine();
    this.factory.setName(name);
    this.createCharacter(this.queue);
  }
  
  /**
   * This method set the factory for character cration.
   */
  
  public void selectCharacter(String s) {
    if (s.equals("Engineer")) {
      this.factory = new EngineerFactory();
      this.factory.setDefense(80);
      this.factory.setMaxHp(200);
    }
    if (s.equals("BlackMage")) {
      this.factory = new BlackMageFactory();
      this.factory.setDefense(70);
      this.factory.setMaxHp(200);
      IMageFactory fac = (IMageFactory) this.factory;
      fac.setMaxMp(150);
    }
    
    if (s.equals("Knight")) {
      this.factory = new KnightFactory();
      this.factory.setDefense(100);
      this.factory.setMaxHp(200);
    }
    if (s.equals("Thief")) {
      this.factory = new ThiefFactory();
      this.factory.setDefense(70);
      this.factory.setMaxHp(150);
    }
  
    if (s.equals("WhiteMage")) {
      this.factory = new WhiteMageFactory();
      this.factory.setDefense(50);
      this.factory.setMaxHp(180);
      IMageFactory fac = (IMageFactory) this.factory;
      fac.setMaxMp(300);
    }
    if (s.equals("Enemy")) {
      this.factory = new EnemyFactory();
      this.factory.setDefense(100);
      this.factory.setMaxHp(100);
      EnemyFactory fac = (EnemyFactory) this.factory;
      fac.setWeight(40);
    }
  }
  
  /**
   *This method creates a new character instance and append it  to the character's Array.
   */
  
  public void createCharacter(TurnsQueue queue) {
    this.characters.add((PlayerCharacter) this.factory.create(queue));
  }
  /**
   *This method creates a new Enemy instance and append it  to the Enemies Array.
   */
  
  public void createEnemy(TurnsQueue queue) {
    this.selectCharacter("Enemy");
    int i = this.enemies.size();
    this.factory.setName("enemy"+i);
    enemies.add( (Enemy) this.factory.create(queue));
  }
  
  
  
  /**
   *Main Example method.
   */
  public static void main(String[] args) {
    Controller c = new Controller();
    while (c.characters.size() != c.maxCharacters) {
      c.askForSingleCharacter();
      for (PlayerCharacter ch : c.characters) {
        System.out.println(ch);
      }
    }
    System.out.println("versus\nEnemies:");
    for (int i = 0;i <=6; i++){
      c.createEnemy(c.queue);
      System.out.println(c.enemies.get(i));
    }
  
    System.out.println("end");
  }
  
  
  
}
