package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.controller.factories.*;
import cl.uchile.dcc.finalreality.exceptions.NotEnughMpException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.controller.factories.*;
import cl.uchile.dcc.finalreality.model.magic.MagicInterface;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Controller which drives the logic of the game.
 */
public class Controller {
  private  ArrayList<PlayerCharacter> characters;
  private  ArrayList<Enemy> enemies;
  
  private  ArrayList<Weapon> inventary;
  
  //inventario
  private static TurnsQueue queue;
  private static  int  maxCharacters = 5;
  private IFactory factory;
  
  private MagicInterface magic;
  
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
   * A getter for the controller's factory.
   */
  
  public void setFactory(IFactory factory) {
    this.factory=factory;
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
   *This method creates a new character instance and append it  to the character's Array.
   */
  
  public void createCharacter() {
    this.characters.add((PlayerCharacter) this.factory.create(this.getQueue()));
  }
  
  /**
   *This method creates a new Enemy instance and append it  to the Enemies Array.
   */
  public void createRandomEnemy() {
    Random random = new Random();
    int p = random.nextInt(30, 120);
    setFactory(new EnemyFactory());
    this.factory.setDefense(p);
    this.factory.setMaxHp(p);
    ((EnemyFactory) this.factory).setWeight(p);
    ((EnemyFactory) this.factory).setAttack(p - 20);
    
    int i = this.enemies.size();
    this.factory.setName("enemy" + i);
    enemies.add((Enemy) factory.create(this.queue));
  }
  
  /**
   *(Adapter) Method to simulate an attack between two GameCharacters, an attacker  and  target .
   */
  public void attack(GameCharacter c1, GameCharacter c2) {
    c2.setCurrentHp(c2.getCurrentHp() - Math.max(0, c1.getAttack() - c2.getDefense()));
  }
  
  /**
   *Method to select a Magic attack and set it into controller.
   */
  
  public void selectMagic(MagicInterface magic) {
    this.magic = magic;
  }
  
  /**
   *Method to get a Magic attack and set it into controller.
   */
  
  public MagicInterface getMagic() {
    return this.magic;
  }
  
  
  /**
   *Method to simulate a  magic attack  from a Mage to a Game Character.
   */
  
  public void useMagic(GameCharacter m, GameCharacter c) throws NotImplementsMagicException, NotEnughMpException {
      m.implementsMagic(this.magic,c);
  }
  
  
  //metodo para equipar del inventario
  //gana player
  // gana enemigo
  
}

