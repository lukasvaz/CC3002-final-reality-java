package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.Player;
import cl.uchile.dcc.finalreality.controller.factories.KnightFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.effects.Burned;
import cl.uchile.dcc.finalreality.model.effects.Paralysis;
import cl.uchile.dcc.finalreality.model.effects.Poisoned;
import cl.uchile.dcc.finalreality.view.NullView;
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
 void action() throws InvalidWeaponAssignmentException, IOException, NullWeaponException, WeaponNotInInventoryException, InterruptedException {
  c.setState(enemyTurn);
  c.setSeed(20);
  c.setView(new NullView());
  c.defaultCharacterSelection();
  Enemy e = c.createRandomEnemy();
  c.setActiveCharacter(e);
  //action, enemy:(63 attack)   attacks Knight:(150hp,50 defense)
  // state should be initTurn
  c.getState().action(c);
  assertEquals(137 ,c.getCharacters().get(1).getCurrentHp());
  assertEquals(initTurn.class,c.getState().getClass());
  
  //action 1 enemy vs 1 character, character should be dead
  //state should be ended, enemies win
  c.setState(enemyTurn);
  c.getCharacters().clear();
  c.setFactory(new KnightFactory());
  GameCharacter p =  c.createCharacter();
  p.setCurrentHp(2);
  c.setActiveCharacter(e);
  c.getState().action(c);
  
  assertEquals(0 ,p.getCurrentHp());
  assertEquals(true,c.getCharacters().isEmpty());
  assertEquals(false,c.getQueue().get_queue().contains(p));
  assertEquals(End.class,c.getState().getClass());
  //enemies with effects
  //setting Poisoned   Effect,enemy should get dmg after its turn
  c.setState(enemyTurn);
  c.setActiveCharacter(e);
  GameCharacter p2 =  c.createCharacter();
  Poisoned poisoned=new Poisoned();
  poisoned.setAssociatedDmg(30);
  e.getEffects().add(poisoned);
  c.getState().action(c);
  assertEquals(137,p2.getCurrentHp());//attack on character:dmg-defense
  assertEquals(53,e.getCurrentHp());//effect on enemy:hp -setAssctdDmg
 Thread.sleep(9000);
  assertEquals(true,c.getQueue().get_queue().contains(e));
  //setting Burned adn Poisoned Effect,enemy should get dmg after its turn
  c.setState(enemyTurn);
  c.setActiveCharacter(e);
  e.setCurrentHp(70);
  GameCharacter p3 =  c.createCharacter();
  Burned burned=new Burned();
  burned.setAssociatedDmg(30);
  Poisoned poisoned2=new Poisoned();
  poisoned.setAssociatedDmg(30);
  e.getEffects().add(burned);
  e.getEffects().add(poisoned2);
  c.getState().action(c);
  assertEquals(137,p2.getCurrentHp());//attack on character:dmg-defense
  assertEquals(10,e.getCurrentHp());//effect on enemy:hp -setAssctdDmg
  Thread.sleep(9000);
  assertEquals(true,c.getQueue().get_queue().contains(e));
  
  //setting Paralysis effect,do nothing , and get to the queue
  c.getCharacters().clear();
  c.setState(enemyTurn);
  Enemy e2=c.createRandomEnemy();
  c.setActiveCharacter(e2);
  e.setCurrentHp(70);
  e.setParalyseCounter(e.getParalyseCounter()+1);
  c.setFactory(new KnightFactory());
  GameCharacter character =  c.createCharacter();
  Paralysis paralysis=new Paralysis();
  assertEquals(1,e.getParalyseCounter());
  assertEquals(1,c.getCharacters().size());
  c.getState().action(c);
  assertEquals(character.getMaxHp(),character.getCurrentHp());//attack on character:dmg-defense
  Thread.sleep(9000);
  assertEquals(true,c.getQueue().get_queue().contains(e));
  
 }
 
 @Test
 void end() {
 }
 
 @Test
 void initTurn() {
 }
}