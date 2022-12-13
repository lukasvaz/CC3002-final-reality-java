package cl.uchile.dcc.finalreality.controller.States;
import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.factories.ThiefFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.view.NullView;
import cl.uchile.dcc.finalreality.view.PrimitiveView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AttackTest {
 StateInterface attack;
 Controller c;
 
 @BeforeEach
 void setUp(){
  c = new Controller();
  attack= new Attack();
 }
 
 
 @Test
 void action() throws InvalidWeaponAssignmentException, IOException, NullWeaponException, WeaponNotInInventoryException, InterruptedException {
  c.setState(attack);
  c.setSeed(20);
  c.setView(new NullView());
  Enemy e1=c.createRandomEnemy();
  Enemy e2=c.createRandomEnemy();
  c.defaultInventary();
  c.setFactory(new ThiefFactory());
  PlayerCharacter t = c.createCharacter();
  c.setActiveCharacter(t);
  c.setTarget(e1);
  //c.setPlayer();
  //not weapon assigned do nothing,enemy hp remains the same
  c.getState().action(c);
  assertEquals(83,c.getTarget().getCurrentHp());
  assertEquals(false,c.getQueue().get_queue().contains(t));
  
  //assign a weapon , enemy's hp to 57 and begins another turn
  // active character to queue
  c.setState(attack);
  Knife k = new Knife("",57,30);
  t.equip(k);
  c.getState().action(c);
  assertEquals(53,c.getTarget().getCurrentHp());
  assertEquals(initTurn.class,c.getState().getClass());
  Thread.sleep(4000);
  assertEquals(true,c.getQueue().get_queue().contains(t));
  
  // kill one enemy , enemy should notify its death, and begins another turn
  //activecharacter to queue
  c.getQueue().get_queue().clear();
  assertEquals(false,c.getQueue().get_queue().contains(t));
  c.setState(attack);
  Knife k2 = new Knife("",200,30);
  t.equip(k2);
  e1.setCurrentHp(80);
  //here simulate target inside queue
  e1.waitTurn();
  Thread.sleep(9000);
  
  assertEquals(true,c.getQueue().get_queue().contains(e1));
  c.getState().action(c);
  Thread.sleep(4000);
  assertEquals(0,c.getTarget().getCurrentHp());
  assertEquals(false,c.getEnemies().contains(e1));
  assertEquals(false,c.getQueue().get_queue().contains(e1));
  assertEquals(false,c.doesPlayerWin());
  assertEquals(initTurn.class,c.getState().getClass());
  assertEquals(true,c.getQueue().get_queue().contains(t));
  //characters Win (both enemies dead)
  c.setState(attack);
  t.equip(k2);//dmg 200
  e1.setCurrentHp(0);
  e1.notifyDmg();
  assertEquals(false,c.getEnemies().contains(e1));//should be axtracted from array
  e2.setCurrentHp(40);
  c.setTarget(e2);
  e2.waitTurn();
  Thread.sleep(9000);
  assertEquals(true,c.getQueue().get_queue().contains(e2));
  c.getState().action(c);
  Thread.sleep(4000);
  assertEquals(0,c.getTarget().getCurrentHp());
  assertEquals(false,c.getEnemies().contains(e2));
  assertEquals(false,c.getQueue().get_queue().contains(e2));
  assertEquals(true,c.doesPlayerWin());
  assertEquals(End.class,c.getState().getClass());
  assertEquals(true,c.getQueue().get_queue().contains(t));
 
 }
 
 @Test
 void updateState() {
 }
 
 @Test
 void initTurn() {
 }
 
 @Test
 void selectEnemy() {
 }
}