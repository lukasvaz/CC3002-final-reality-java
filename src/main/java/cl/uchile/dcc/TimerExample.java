package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This is an axample of use of the turn´s system. Here we create a character
 * of each class, we add them into the
 * queue.Then the names will be printed  ordered by its weights.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 */
public class TimerExample {
  
  /**
   * Run test
   * Waits for 12 seconds to ensure that all characters have finished waiting
   *  Pops and prints the names of the characters of the queue to illustrate the turns.
   */

  public static void main(String[] args)
      throws InterruptedException, InvalidStatValueException {
    TurnsQueue turns = new TurnsQueue();
    Random rng = new Random();
    for (int i = 0; i < 2; i++) {
      // Create a weapon for playable characters, the weight is random
      // Create a character of each class
      //we equip weapon to the playable characters
      Weapon knife = new Weapon("knife weight", 0, rng.nextInt(10, 100), WeaponType.KNIFE);
      Thief thief = new Thief(Integer.toString(i), 100, 10, turns);
      thief.equip(knife);
      Weapon axe = new Weapon("axe", 0, rng.nextInt(10, 100), WeaponType.AXE);
      Engineer engineer = new Engineer(Integer.toString(i), 100, 10, turns);
      engineer.equip(axe);
      Weapon sword = new Weapon("sword", 0, rng.nextInt(10, 100), WeaponType.SWORD);
      Knight knight = new Knight(Integer.toString(i), 100, 10, turns);
      knight.equip(sword);
      Weapon wstaff = new Weapon("white staff", 0, rng.nextInt(10, 100), WeaponType.STAFF);
      WhiteMage whitemage = new WhiteMage(Integer.toString(i), 50, 10, 50, turns);
      whitemage.equip(wstaff);
      BlackMage blackmage = new BlackMage(Integer.toString(i), 50, 80, 50, turns);
      Weapon bstaff = new Weapon("black staff", 0, rng.nextInt(10, 100), WeaponType.STAFF);
      blackmage.equip(bstaff);
      Enemy enemy = new Enemy(Integer.toString(i),  rng.nextInt(10, 100), 10, 50, turns);
      //each caracter waits for their turns
      enemy.waitTurn();
      thief.waitTurn();
      knight.waitTurn();
      engineer.waitTurn();
      blackmage.waitTurn();
      whitemage.waitTurn();
      
    }
    // Waits for 12 seconds to ensure that all characters have finished waiting
    Thread.sleep(12000);
    while (!turns.get_queue().isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      var character = turns.get_queue().poll();
      if (character instanceof AbstractPlayerCharacter) {
        System.out.println(character.toString());
        System.out.println(((AbstractPlayerCharacter) character).getEquippedWeapon().getWeight());
      }
      if (character instanceof Enemy)  {
        System.out.println(character.toString());
        System.out.println(((Enemy) character).getWeight());
      }
    }
  }
}
