package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractPlayerCharacterTest {
 
 @Test
 void equipAndGet() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  Knight knight = new Knight("knight1", 10, 10, queue);
  Axe axe = new Axe("axe1",30,30);
  knight.equip(axe);
  assertEquals(axe,knight.getEquippedWeapon());
 }
 
 @Test
 void waitTurn() throws InvalidStatValueException, InterruptedException {
  TurnsQueue queue = new TurnsQueue();
  Knight knight = new Knight("knight", 10, 100, queue);
  Thief thief = new Thief("thief", 20, 100,queue);
  Engineer engineer = new Engineer("eng", 30, 100,queue);
  
  Sword sword= new Sword("sword1",30,10);
  Knife knife= new Knife("knife1", 30,20);
  Axe axe = new Axe("axe1",30,30);
  
  knight.equip(sword);
  thief.equip(knife);
  engineer.equip(axe);
  
  knight.waitTurn();
  thief.waitTurn();
  engineer.waitTurn();
  Thread.sleep(8000);
  assertEquals(knight,queue.get_queue().poll());
  assertEquals(thief,queue.get_queue().poll());
  assertEquals(engineer,queue.get_queue().poll());
 
 }
}