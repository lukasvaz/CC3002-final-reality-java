package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractCharacterTest {
 
 
 @Test
 void addToQueue() throws InvalidStatValueException {
  TurnsQueue queue = new TurnsQueue();
  Knight knight = new Knight("knight1", 100, 30, queue);
  Enemy enemy = new Enemy("enemy", 300, 100, 30, queue);
  Enemy enemy2 = new Enemy("enemy", 2, 100, 30, queue);
  knight.addToQueue();
  enemy.addToQueue();
  enemy2.addToQueue();
  assertEquals(knight, queue.get_queue().poll());
  assertEquals(enemy, queue.get_queue().poll());
  assertEquals(enemy2, queue.get_queue().poll());
 }
 
 @Test
 void getName() throws InvalidStatValueException {
  TurnsQueue queue = new TurnsQueue();
  Knight knight = new Knight("knight1", 100, 30, queue);
  Enemy enemy = new Enemy("", 300, 100, 30, queue);
  assertEquals("knight1", knight.getName());
  assertEquals("", enemy.getName());
 }
 @Test
 void setandgetCurrentHp() throws InvalidStatValueException {
  TurnsQueue queue = new TurnsQueue();
  Knight knight = new Knight("knight1", 100, 30, queue);
  Enemy enemy = new Enemy("", 300, 1, 30, queue);
  assertEquals(1, enemy.getCurrentHp());
  assertEquals(100, knight.getCurrentHp());
  enemy.setCurrentHp(1);
  knight.setCurrentHp(1);
  assertEquals(1, enemy.getCurrentHp());
  assertEquals(1, knight.getCurrentHp());
 }
 
 @Test
 void getMaxHp() throws InvalidStatValueException {
  TurnsQueue queue = new TurnsQueue();
  Knight knight = new Knight("knight1", 100, 30, queue);
  Enemy enemy = new Enemy("", 300, 10, 30, queue);
  assertEquals(100, knight.getMaxHp());
  assertEquals(10, enemy.getMaxHp());
  enemy.setCurrentHp(1);
  knight.setCurrentHp(10);
  assertEquals(100, knight.getMaxHp());
  assertEquals(10, enemy.getMaxHp());
 }
 
 
 @Test
 void getDefense() throws InvalidStatValueException {
  TurnsQueue queue = new TurnsQueue();
  Knight knight = new Knight("knight1", 100, 30, queue);
  Enemy enemy = new Enemy("", 300, 10, 1, queue);
  assertEquals(30, knight.getDefense());
  assertEquals(1, enemy.getDefense());
  
 }
}