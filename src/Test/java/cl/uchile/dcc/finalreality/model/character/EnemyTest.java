package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
 
 @Test
 void getWeight() throws InvalidStatValueException {
  TurnsQueue queue = new TurnsQueue();
  Enemy enemy1 = new Enemy("enemy1", 30, 100, 40, queue);
  Enemy enemy2 = new Enemy("enemy1", 1, 100,40,queue);
  assertEquals(30, enemy1.getWeight());
  assertEquals(1, enemy2.getWeight());
 }
 
 @Test
 void testEquals() throws InvalidStatValueException {
  TurnsQueue queue = new TurnsQueue();
  Enemy enemy1 = new Enemy("enemy1", 30, 100, 40, queue);
  Enemy enemy2 = new Enemy("enemy1", 30, 100,40,queue);
  Enemy enemy3 = new Enemy("enemy1", 1, 100,40,queue);
  Enemy enemy4 = new Enemy("enemy1", 30, 10,40,queue);
  Enemy enemy5 = new Enemy("enemy2", 30, 10,40,queue);
  Knight enemy6 = new Knight("enemy2", 30, 40,queue);
  assertTrue( enemy1.equals(enemy1));
  assertTrue( enemy1.equals(enemy2));
  assertFalse(enemy1.equals(enemy3));
  assertFalse(enemy1.equals(enemy4));
  assertFalse(enemy1.equals(enemy5));
  assertFalse(enemy1.equals(enemy6));
 }
 
 @Test
 void testHashCode() throws  InvalidStatValueException{
  TurnsQueue queue = new TurnsQueue();
  Enemy enemy1 = new Enemy("enemy1", 30, 100, 40, queue);
  Enemy enemy2 = new Enemy("enemy1", 30, 100,40,queue);
  assertEquals(enemy1.hashCode(),enemy2.hashCode());
  assertEquals(enemy1.hashCode(),enemy1.hashCode());
 }
 
 @Test
 void waitTurn() throws InvalidStatValueException, InterruptedException {
  TurnsQueue queue = new TurnsQueue();
  Enemy enemy1 = new Enemy("enemy1", 10, 100, 40, queue);
  Enemy enemy2 = new Enemy("enemy2", 20, 100,40,queue);
  Enemy enemy3 = new Enemy("enemy3", 30, 100,40,queue);
  enemy1.waitTurn();
  enemy2.waitTurn();
  enemy3.waitTurn();
  Thread.sleep(12000);
  assertEquals(enemy1,queue.get_queue().poll());
  assertEquals(enemy2,queue.get_queue().poll());
  assertEquals(enemy3,queue.get_queue().poll());
  
 }
 
 @Test
 void testToString() throws InvalidStatValueException {
  TurnsQueue queue = new TurnsQueue();
  Enemy enemy1 = new Enemy("enemy1", 10, 100, 40, queue);
 assertEquals("Enemy{maxHp=100,wheight=10, defense=40, name='enemy1'}",enemy1.toString());
 }

}