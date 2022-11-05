package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.Random;

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
    for (int i = 0; i < 1; i++) {
      // Create a weapon for playable characters, the weight is random
      // Create a character of each class
      //we equip weapon to the playable characters
      Weapon knife = new Knife("knife weight", 0, rng.nextInt(10, 100));
      Thief thief = new Thief(Integer.toString(i), 100, 10, turns);
      thief.equip(knife);
      Weapon axe = new Axe("axe", 0, rng.nextInt(10, 100));
      Engineer engineer = new Engineer(Integer.toString(i), 100, 10, turns);
      engineer.equip(axe);
      Weapon sword = new Sword("sword", 0, rng.nextInt(10, 100));
      Knight knight = new Knight(Integer.toString(i), 100, 10, turns);
      knight.equip(sword);
      Weapon wstaff = new Staff("white staff", 0, rng.nextInt(10, 100));
      WhiteMage whitemage = new WhiteMage(Integer.toString(i), 50, 10, 50, turns);
      whitemage.equip(wstaff);
      BlackMage blackmage = new BlackMage(Integer.toString(i), 50, 80, 50, turns);
      Weapon bstaff = new Staff("black staff", 0, rng.nextInt(10, 100));
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
        System.out.println(character);
        System.out.println(((AbstractPlayerCharacter) character).getEquippedWeapon().getWeight());
      }
      if (character instanceof Enemy)  {
        System.out.println(character);
        System.out.println(((Enemy) character).getWeight());
      }
    }
  }
}
