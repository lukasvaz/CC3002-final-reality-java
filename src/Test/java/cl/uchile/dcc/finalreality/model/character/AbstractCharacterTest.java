package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
  enemy = new Enemy("", 300, 1, 1, 10,queue);
  enemy2 = new Enemy("enemy", 2, 100, 30, 10,queue);
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
 
 @Test
 void attack() throws InvalidWeaponAssignmentException {
  //avg case:enemy def=30
  knight.equip(new Axe("",60,30));
  enemy2.setCurrentHp(40);
  knight.attack(enemy2);
  assertEquals(10,enemy2.getCurrentHp());
  // defense>attack, do nothing def=30
  knight.equip(new Axe("",20,30));
  enemy2.setCurrentHp(40);
  knight.attack(enemy2);
  assertEquals(40,enemy2.getCurrentHp());
  //attack> currentHp , should be 0
  knight.equip(new Axe("",100,30));
  enemy2.setCurrentHp(40);
  knight.attack(enemy2);
  assertEquals(0,enemy2.getCurrentHp());
 
 }
 @Test
 void notifyDmg(){
  Controller controller = new Controller();
  controller.getEnemies().clear();
  controller.getQueue().get_queue().clear();
  Enemy e = controller.createRandomEnemy();
  controller.getQueue().get_queue().add(e);
  assertEquals(new ArrayList<Enemy>(Arrays.asList(e)), controller.getEnemies());
  assertEquals(true, controller.getQueue().get_queue().contains(e));
  //setting hp to 0
  e.setCurrentHp(0);
  e.notifyDmg();
  //should extract it  from queue and array
  assertEquals(new ArrayList<Enemy>(Arrays.asList()), controller.getEnemies());
  assertEquals(false, controller.getQueue().get_queue().contains(e));
  
 }
 
 }