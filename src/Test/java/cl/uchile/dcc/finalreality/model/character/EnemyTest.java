package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.effects.*;
import cl.uchile.dcc.finalreality.model.magic.Heal;
import cl.uchile.dcc.finalreality.model.magic.MagicInterface;
import cl.uchile.dcc.finalreality.model.magic.Thunder;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
 TurnsQueue queue;
 Enemy enemy1;
 Enemy enemy2;
 Enemy enemy3;
 Enemy enemy4;
 Enemy enemy5;
 Knight knight;
 
 Controller controller;
 
 Burned burned;
 Paralysis paralysis;
 Poisoned poisoned;
 @BeforeEach
 void setup() throws InvalidStatValueException {
  controller = new Controller();
  queue = new TurnsQueue();
  enemy1 = new Enemy("enemy1", 30, 100, 40,10, queue);
  enemy2 = new Enemy("enemy1", 30, 100,40,20,queue);
  enemy3 = new Enemy("enemy1", 1, 100,40,30,queue);
  enemy4 = new Enemy("enemy1", 30, 10,40,40,queue);
  enemy5 = new Enemy("enemy1", 30, 100,30,10,queue);
  knight = new Knight("enemy1", 30, 40,queue);
  burned= new Burned();
  paralysis= Paralysis.uniqueInstance();
  poisoned = new Poisoned();
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
 
  System.out.println("wait Turn"+queue.get_queue());
  Enemy enemyLast = new Enemy("enemyLast", 30, 100, 40,10, queue);
  Enemy enemymidlle = new Enemy("enemyMidlle", 20, 100,40,10,queue);
  Enemy enemyFirst = new Enemy("enemyFirst", 10, 100,40,10,queue);
  
  enemyLast.waitTurn();
  enemymidlle.waitTurn();
  enemyFirst.waitTurn();
  
  Thread.sleep(8000);
  assertEquals(enemyFirst,queue.get_queue().poll());
  assertEquals(enemymidlle,queue.get_queue().poll());
  assertEquals(enemyLast,queue.get_queue().poll());
  
  queue.get_queue().clear();
 
 }
 
 @Test
 void testToString() throws InvalidStatValueException {
 assertEquals("Enemy{maxHp=100,weight=30, defense=40, name='enemy1', attack=10}",enemy1.toString());
 }
 @Test
 void testInvalidStatException() throws InvalidStatValueException {
  assertThrows(InvalidStatValueException.class, ()-> {new Enemy("name",0,0,40,10,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new Enemy("name",40,40,-1,10,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new Enemy("name",0,40,-1,10,queue);});
 }
 @Test
 void getAttack(){
 assertEquals(enemy1.getAttack(),10);
 assertEquals(enemy2.getAttack(),20);
 assertEquals(enemy3.getAttack(),30);
 assertEquals(enemy4.getAttack(),40);
 assertEquals(enemy5.getAttack(),10);
 }
 
 @Test
 void getAndSetandIsAnyEffect(){
  //inicialy emtpy
  assertEquals(true, enemy1.getEffects().isEmpty());
  
  //after setting some effects
  enemy1.setEffect( Paralysis.uniqueInstance() );
  assertEquals(1, enemy1.getParalyseCounter());
  
  //after setting  the same effect
  enemy1.setEffect( Paralysis.uniqueInstance() );
  assertEquals(2, enemy1.getParalyseCounter());
  assertEquals(new ArrayList<EffectsInterface>(),
          enemy1.getEffects());
  
  //setting another effect
  Poisoned p =new Poisoned();
  enemy1.setEffect( p);
  assertEquals(1, enemy1.getEffects().size());
  assertEquals(new ArrayList<EffectsInterface>(Arrays.asList(p)), enemy1.getEffects());
  assertEquals(true, enemy1.isAnyEffect(p));
  
  //setting another effect
  Burned b = new Burned();
  enemy1.setEffect( b );
  assertEquals(2, enemy1.getEffects().size());
  assertEquals(new ArrayList<EffectsInterface>(Arrays.asList(b,p)),
          enemy1.getEffects());
  assertEquals(true, enemy1.isAnyEffect(new Burned()));
 }
 
 @Test
 void testImplementsMagic() throws InvalidWeaponAssignmentException {
  Thunder t = new Thunder();
  Heal h = new Heal();
  assertThrows(NotImplementsMagicException.class, ()-> enemy1.implementsMagic (h,enemy2));
  assertThrows(NotImplementsMagicException.class, ()-> enemy1.implementsMagic (t,enemy2));
 }
 
 @Test
 void notifyEffects() throws InterruptedException, NullWeaponException {
  //each effect by separate
  //paralysis
  
  enemy1=new Enemy("",20,100,30,30,controller.getQueue());
  enemy1.notifyEffects();
  enemy1.setController(controller);
  enemy1.setEffect(paralysis);
  assertEquals(1,enemy1.getParalyseCounter());
  enemy1.notifyEffects();
  assertEquals(0,enemy1.getParalyseCounter());
  Thread.sleep(5000);
  assertEquals( enemy1, controller.getQueue().get_queue().poll());
  //Burned
  assertEquals(new ArrayList<EffectsInterface>(Arrays.asList()),enemy1.getEffects());
  enemy1.setCurrentHp(100);
  burned.setAssociatedDmg(20);
  enemy1.setEffect(burned);
  System.out.println(enemy1.getEffects());
  enemy1.notifyEffects();
  assertEquals(80, enemy1.getCurrentHp());
  assertEquals(new ArrayList<EffectsInterface>(Arrays.asList(burned)),enemy1.getEffects());
  
  enemy1.getEffects().remove(burned);
  //Poisoned
  assertEquals(new ArrayList<EffectsInterface>(Arrays.asList()),enemy1.getEffects());
  poisoned.setAssociatedDmg(30);
  enemy1.setCurrentHp(100);
  enemy1.setEffect(poisoned);
  enemy1.notifyEffects();
  assertEquals(70, enemy1.getCurrentHp());
  assertEquals(new ArrayList<EffectsInterface>(Arrays.asList(poisoned)),enemy1.getEffects());
 
  enemy1.getEffects().remove(poisoned);
  
  //multiples Effects
  enemy1.setCurrentHp(100);
  assertEquals(0,enemy1.getParalyseCounter());
  enemy1.setEffect(paralysis);
  assertEquals(1,enemy1.getParalyseCounter());
  enemy1.setEffect(poisoned);
  poisoned.setAssociatedDmg(30);
  enemy1.setEffect(burned);
  burned.setAssociatedDmg(20);
  enemy1.notifyEffects();
  assertEquals(0,enemy1.getParalyseCounter());
  assertEquals(50, enemy1.getCurrentHp());
  assertEquals(new ArrayList<EffectsInterface>(Arrays.asList(burned,poisoned)),enemy1.getEffects());
  
 }
 @Test
 void dead() throws NullWeaponException, InterruptedException {
  controller.getEnemies().clear();
  controller.getQueue().get_queue().clear();
  Enemy e = controller.createRandomEnemy();
  controller.getQueue().get_queue().add(e);
  assertEquals(new ArrayList<Enemy>(Arrays.asList(e)), controller.getEnemies());
  assertEquals(true, controller.getQueue().get_queue().contains(e));
  //kill e , means extract it from queue and  array
  e.dead();
  assertEquals(new ArrayList<Enemy>(Arrays.asList()), controller.getEnemies());
  assertEquals(false, controller.getQueue().get_queue().contains(e));

 }
 
}