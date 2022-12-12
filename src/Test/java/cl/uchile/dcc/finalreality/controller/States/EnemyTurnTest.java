package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.Player;
import cl.uchile.dcc.finalreality.controller.factories.KnightFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.view.PrimitiveView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTurnTest {
 
 StateInterface enemyTurn;
 Controller c;
 
 @BeforeEach
 void setUp(){
  c = new Controller();
  enemyTurn = new EnemyTurn();
  
 }
 
 @Test
 void action() throws InvalidWeaponAssignmentException, IOException, NullWeaponException, WeaponNotInInventoryException {
  c.setState(enemyTurn);
  c.setSeed(20);
  c.setView(new PrimitiveView());
  c.defaultCharacterSelection();
  Enemy e = c.createRandomEnemy();
  c.setActiveCharacter(e);
  //action, enemy:(63 attack)   attacks Knight:(150hp,50 defense)
  // state should be initTurn
  c.getState().action(c);
  assertEquals(137 ,c.getCharacters().get(1).getCurrentHp());
  assertEquals(initTurn.class,c.getState().getClass());
  
  //action 1 enemy vs 1 character, character should be dead
  //state should be ended
  c.setState(enemyTurn);
  c.getCharacters().clear();
  c.setFactory(new KnightFactory());
  GameCharacter p =  c.createCharacter();
  p.setCurrentHp(2);
  c.setActiveCharacter(e);
  c.setRandomCharacterTarget();
  System.out.println(c.getCharacters());
  System.out.println(c.getActiveCharacter());
  c.getState().action(c);
  assertEquals(0 ,p.getCurrentHp());
  assertEquals(true,c.getCharacters().isEmpty());
  assertEquals(false,c.getQueue().get_queue().contains(p));
  assertEquals(End.class,c.getState().getClass());
 
 
 }
 
 @Test
 void end() {
 }
 
 @Test
 void initTurn() {
 }
}