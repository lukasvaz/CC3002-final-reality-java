package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import java.util.Random;

/**
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 */
public class TimerExample {


  public static void main(String[] args)
      throws InterruptedException, InvalidStatValueException {
    TurnsQueue turns = new TurnsQueue();

    Random rng = new Random();
    for (int i = 0; i < 10; i++) {
      // Gives a random speed to each character to generate different waiting times
      var weapon = new Weapon("", 0, rng.nextInt(50), WeaponType.KNIFE);
      var character = new Thief(Integer.toString(i), 10, 10, turns);
      var enemy=new Enemy(Integer.toString(i), rng.nextInt(50), 10, 10,turns);
      character.equip(weapon);
      character.waitTurn();
      enemy.waitTurn();
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000);
    while (!turns.get_queue().isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      System.out.println(turns.get_queue().poll().toString());
    }
  }
}
