package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.factories.*;
import java.util.ArrayList;
import java.util.Random;
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
   * A setter for the maximum numbers of characters.
   */
  
  public void setMaxCharacters(int max) {
    this.maxCharacters = max;
  }
  
  /**
   * A method that checks if the number of character is equal to  the max number.
   */
  
  public boolean isMaxCharacters() {
    return (this.maxCharacters == this.getCharacters().size());
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
    this.factory.setName(name);
    this.createCharacter(this.queue);
  }
  
  /**
   * This method set the factory for character cration.
   */
  
  public void selectCharacterCreation(String s) {
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
    Random random = new Random();
    int p = random.nextInt(30, 120);
    this.selectCharacterCreation("Enemy");
    this.factory.setDefense(p);
    this.factory.setMaxHp(p);
    ((EnemyFactory) this.factory).setWeight(p);
    ((EnemyFactory) this.factory).setAttack(p - 20);
    int i = this.enemies.size();
    this.factory.setName("enemy" + i);
    enemies.add((Enemy) this.factory.create(queue));
  }
  
  /**
   *Method to simulate an attack between two GameCharacters, an attacker  and  a target.
   */
  public void attack(GameCharacter c1, GameCharacter c2) {
    c2.setCurrentHp(c2.getCurrentHp() - Math.max(0, c1.getAttack() - c2.getDefense()));
  }
}
