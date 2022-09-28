package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * This is an axample of use of the turn´s system. Here we create a character of each class, we add them into the
 * queue.Then the names will be printed  ordered by its weights.
 */
public class TimerExample {

  public static void main(String[] args)
      throws InterruptedException, InvalidStatValueException {
      TurnsQueue turns = new TurnsQueue();
    Random rng = new Random();
    for (int i = 0; i < 2; i++) {
      // Create a weapon for playable characters, the weight is random
      var knife= new Weapon("knife weight", 0, rng.nextInt(10,100), WeaponType.KNIFE);
      var axe = new Weapon("axe", 0, rng.nextInt(10,100), WeaponType.AXE);
      var sword = new Weapon("sword", 0, rng.nextInt(10,100), WeaponType.SWORD);
      var w_staff = new Weapon("white staff", 0, rng.nextInt(10,100), WeaponType.STAFF);
      var b_staff = new Weapon("black staff", 0, rng.nextInt(10,100), WeaponType.STAFF);
      // Create a character if each class
      var thief = new Thief(Integer.toString(i), 100, 10, turns);
      var knight = new Knight(Integer.toString(i), 100, 10, turns);
      var engineer = new Engineer(Integer.toString(i), 100, 10, turns);
      var black_mage =new BlackMage(Integer.toString(i), 50, 80, 50,turns);
      var white_mage =new WhiteMage(Integer.toString(i), 50, 10, 50,turns);
      var enemy= new Enemy(Integer.toString(i),  rng.nextInt(10,100), 10, 50,turns);

      //we equip weapon to the playable characters
      thief.equip(knife);
      knight.equip(sword);
      engineer.equip(axe);
      black_mage.equip(b_staff);
      white_mage.equip(w_staff);

      //each caracter waits for their turns
      thief.waitTurn();
      knight.waitTurn();
      engineer.waitTurn();
      black_mage.waitTurn();
      white_mage.waitTurn();
      enemy.waitTurn();
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000);
    while (!turns.get_queue().isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      var character=turns.get_queue().poll();
      if (character instanceof AbstractPlayerCharacter){
      System.out.println(character.toString());
      System.out.println(((AbstractPlayerCharacter) character).getEquippedWeapon().getWeight());}

    else{System.out.println(character.toString());
        System.out.println( ((Enemy)character).getWeight());
    }
  }
}
}
