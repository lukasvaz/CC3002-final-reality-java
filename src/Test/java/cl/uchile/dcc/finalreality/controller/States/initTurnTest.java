package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.factories.EnemyFactory;
import cl.uchile.dcc.finalreality.controller.factories.EngineerFactory;
import cl.uchile.dcc.finalreality.controller.factories.KnightFactory;
import cl.uchile.dcc.finalreality.controller.factories.WhiteMageFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.view.PrimitiveView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class initTurnTest {

 StateInterface initTurn;
 Controller c;
 @BeforeEach
 void setUp(){
  c = new Controller();
  initTurn = new initTurn();
 }
 
 @Test
 void action() throws InvalidWeaponAssignmentException, WeaponNotInInventoryException, NullWeaponException, InterruptedException, IOException {
  
  //Character creation sim
  c.setState(new initTurn());
  c.setView(new PrimitiveView());
  c.setFactory(new KnightFactory());
  PlayerCharacter p=c.createCharacter();
  p.equip(new Axe("test",30,30));
  assertEquals(true,c.getCharacters().contains(p));
  p.waitTurn();
  Thread.sleep(5000);
  assertEquals(true, c.getQueue().get_queue().contains(p));
  //test state change
  c.getState().action(c);
  assertEquals(p,c.getActiveCharacter());
  assertEquals(CharacterTurn.class,c.getState().getClass());
  c.getQueue().get_queue().clear();
 
  // magic Character creation sim
  c.setState(new initTurn());
  c.setView(new PrimitiveView());
  c.setFactory(new WhiteMageFactory());
  PlayerCharacter w = c.createCharacter();
  w.equip(new Staff("test",30,30,30));
  assertEquals(true,c.getCharacters().contains(w));
  w.waitTurn();
  Thread.sleep(5000);
  assertEquals(true, c.getQueue().get_queue().contains(w));
  //test state change
  c.getState().action(c);
  assertEquals(w,c.getActiveCharacter());
  assertEquals(MagicCharacterTurn.class,c.getState().getClass());
  c.getQueue().get_queue().clear();
 
  //Enemy example
  c.setState(new initTurn());
  c.setFactory(new EnemyFactory());
  Enemy e=c.createRandomEnemy();
  assertEquals(true,c.getEnemies().contains(e));
  e.waitTurn();
  Thread.sleep(e.getWeight()*100+1000);//seg(e.weight)+1 seg
  //test state change
  assertEquals(true, c.getQueue().get_queue().contains(e));
  c.getState().action(c);
  assertEquals(e,c.getActiveCharacter());
  assertEquals(EnemyTurn.class,c.getState().getClass());
 }
 
 @Test
 void enemyTurn() {
  c.setState(new initTurn());
  c.getState().enemyTurn(c);
  assertEquals(EnemyTurn.class,c.getState().getClass());
 }
 
 @Test
 void characterTurn() {
  c.setState(new initTurn());
  c.getState().characterTurn(c);
  assertEquals(CharacterTurn.class,c.getState().getClass());
 }
 
 @Test
 void magicCharacterTurn() {
  c.setState(new initTurn());
  c.getState().magicCharacterTurn(c);
  assertEquals(MagicCharacterTurn.class,c.getState().getClass());
  
 }
}