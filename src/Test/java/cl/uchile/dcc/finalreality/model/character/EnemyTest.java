package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
 TurnsQueue queue;
 Enemy enemy1;
 Enemy enemy2;
 Enemy enemy3;
 Enemy enemy4;
 Enemy enemy5;
 Knight knight;
 
 @BeforeEach
 void setup() throws InvalidStatValueException {
  queue = new TurnsQueue();
  enemy1 = new Enemy("enemy1", 30, 100, 40, queue);
  enemy2 = new Enemy("enemy1", 30, 100,40,queue);
  enemy3 = new Enemy("enemy1", 1, 100,40,queue);
  enemy4 = new Enemy("enemy1", 30, 10,40,queue);
  enemy5 = new Enemy("enemy1", 30, 100,30,queue);
  knight = new Knight("enemy1", 30, 40,queue);
 
 }
  @Test
 void getWeight() throws InvalidStatValueException {
  assertEquals(30, enemy1.getWeight());
  assertEquals(1, enemy3.getWeight());
 }
 
 @Test
 void testEquals() throws InvalidStatValueException {
  assertTrue(enemy1.equals(enemy1));
  assertTrue( enemy1.equals(enemy2));
  assertFalse(enemy1.equals(enemy3));
  assertFalse(enemy1.equals(enemy4));
  assertFalse(enemy1.equals(enemy5));
  assertFalse(enemy1.equals(knight));
 }
 
 @Test
 void testHashCode() throws  InvalidStatValueException{
  assertEquals(enemy1.hashCode(),enemy2.hashCode());
  assertEquals(enemy1.hashCode(),enemy1.hashCode());
 }
 
 @Test
 void waitTurn() throws InvalidStatValueException, InterruptedException {
  enemy1 = new Enemy("enemy1", 30, 100, 40, queue);
  enemy2 = new Enemy("enemy2", 20, 100,40,queue);
  enemy3 = new Enemy("enemy3", 10, 100,40,queue);
  enemy1.waitTurn();
  enemy2.waitTurn();
  enemy3.waitTurn();
  Thread.sleep(12000);
  assertEquals(enemy3,queue.get_queue().poll());
  assertEquals(enemy2,queue.get_queue().poll());
  assertEquals(enemy1,queue.get_queue().poll());
  
 }
 
 @Test
 void testToString() throws InvalidStatValueException {
 assertEquals("Enemy{maxHp=100,wheight=30, defense=40, name='enemy1'}",enemy1.toString());
 }
 @Test
 void testInvalidStatException() throws InvalidStatValueException {
  assertThrows(InvalidStatValueException.class, ()-> {new Enemy("name",0,0,40,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new Enemy("name",40,40,-1,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new Enemy("name",0,40,-1,queue);});
 }

}