package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractCharacterTest {
 TurnsQueue queue;
 Knight knight;
 Enemy enemy;
 Enemy enemy2;
 @BeforeEach
 void setup() throws InvalidStatValueException {
  queue = new TurnsQueue();
  knight = new Knight("knight1", 100, 30, queue);
  enemy = new Enemy("", 300, 1, 1, queue);
  enemy2 = new Enemy("enemy", 2, 100, 30, queue);
 }
 
 @Test
 void addToQueue()  {
  knight.addToQueue();
  enemy.addToQueue();
  enemy2.addToQueue();
  assertEquals(knight, queue.get_queue().poll());
  assertEquals(enemy, queue.get_queue().poll());
  assertEquals(enemy2, queue.get_queue().poll());
  assertEquals(null, queue.get_queue().poll());
 }
 
 @Test
 void getName()  {
  assertEquals("knight1", knight.getName());
  assertEquals("", enemy.getName());
 }
 @Test
 void setandgetCurrentHp() throws InvalidStatValueException {
  assertEquals(1, enemy.getCurrentHp());
  assertEquals(100, knight.getCurrentHp());
  enemy.setCurrentHp(1);
  knight.setCurrentHp(1);
  assertEquals(1, enemy.getCurrentHp());
  assertEquals(1, knight.getCurrentHp());
  assertThrows(InvalidStatValueException.class, ()-> {enemy.setCurrentHp(-1);});
  assertThrows(InvalidStatValueException.class, ()-> {knight.setCurrentHp(101);});
  
 }
 
 @Test
 void getMaxHp() throws InvalidStatValueException {
  assertEquals(100, knight.getMaxHp());
  assertEquals(1, enemy.getMaxHp());
  enemy.setCurrentHp(1);
  knight.setCurrentHp(1);
  assertEquals(100, knight.getMaxHp());
  assertEquals(1, enemy.getMaxHp());
 }
 
 
 @Test
 void getDefense()  {
  assertEquals(30, knight.getDefense());
  assertEquals(1, enemy.getDefense());
  
 }
 @Test
 void testInvalidStatException() {
  assertThrows(InvalidStatValueException.class, ()-> {new Thief("thirf1",0,40,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new Knight("thirf1",40,-1,queue);});
 }
}