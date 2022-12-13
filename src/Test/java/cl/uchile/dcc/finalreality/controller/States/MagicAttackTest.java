package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.factories.BlackMageFactory;
import cl.uchile.dcc.finalreality.controller.factories.ThiefFactory;
import cl.uchile.dcc.finalreality.controller.factories.WhiteMageFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.effects.Burned;
import cl.uchile.dcc.finalreality.model.effects.Paralysis;
import cl.uchile.dcc.finalreality.model.effects.Poisoned;
import cl.uchile.dcc.finalreality.model.magic.Fire;
import cl.uchile.dcc.finalreality.model.magic.Heal;
import cl.uchile.dcc.finalreality.model.magic.Poison;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.view.NullView;
import cl.uchile.dcc.finalreality.view.PrimitiveView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MagicAttackTest {
 StateInterface magicAttack;
 Controller c;
 
 @BeforeEach
 void setUp(){
  c = new Controller();
  magicAttack= new MagicAttack();
 }
 
 
 @Test
 void action() throws InvalidWeaponAssignmentException, IOException, NullWeaponException, WeaponNotInInventoryException, InterruptedException {
  c.setSeed(20);
  c.setView(new NullView());
  Enemy e1=c.createRandomEnemy();
  Enemy e2=c.createRandomEnemy();
  c.setMagic(new Poison());
  c.setTarget(e1);
  c.defaultInventary();
  //character does not imlemts magic, back to select enemy
  //active character not to queue
  c.setState(magicAttack);
  c.setFactory(new ThiefFactory());
  PlayerCharacter t = c.createCharacter();
  c.setActiveCharacter(t);
  c.getState().action(c);
  assertEquals(selectEnemy.class,c.getState().getClass());
  assertEquals(e1.getMaxHp(),e1.getCurrentHp());
  assertEquals(false,c.getQueue().get_queue().contains(t));
 
  //Blackmage does not imlemts heal, back to select enemy
  c.setState(magicAttack);
  c.setFactory(new BlackMageFactory());
  PlayerCharacter b = c.createCharacter();
  c.setActiveCharacter(b);
  c.getState().action(c);
  assertEquals(selectEnemy.class,c.getState().getClass());
  assertEquals(e1.getMaxHp(),e1.getCurrentHp());
  assertEquals(false,c.getQueue().get_queue().contains(b));
 
  //WhiteMage uses Poison but has no weapon, do nothing
  c.setFactory(new WhiteMageFactory());
  PlayerCharacter w = c.createCharacter();
  c.setActiveCharacter(w);
  c.setState(magicAttack);
  c.getState().action(c);
  assertEquals(selectEnemy.class,c.getState().getClass());
  assertEquals(e1.getMaxHp(),e1.getCurrentHp());
  assertEquals(false,c.getQueue().get_queue().contains(w));
 
  // Whitemage uses poison on e1,should get Poisoned and starts a new turn
  //wm to the queue
  w.equip(new Staff("",10,30,30));
  c.setState(magicAttack);
  c.setTarget(e1);
  c.getState().action(c);
  Thread.sleep(4000);
  assertEquals(1,e1.getEffects().size());
  assertEquals(Poisoned.class,e1.getEffects().get(0).getClass());
  assertEquals(30,e1.getEffects().get(0).getAssociatedDamage());
  assertEquals(initTurn.class,c.getState().getClass());
  assertEquals(true,c.getQueue().get_queue().contains(w));
 
  //BlackMage attacks an Enemy with Fire,
  // magicDmg in Knife is its normal Dmg/2 -> plus assoctedDmg in Fire /2 => total Dmg/4
  // enemy dies
  //black to the queue
  // starts a new turn
  c.getQueue().get_queue().clear();
  c.setFactory(new BlackMageFactory());
  GameCharacter b2= c.createCharacter();
  b.equip(new Knife("",300,30));
  c.setActiveCharacter(b);
  c.setState(magicAttack);
  c.setTarget(e1);
  Fire f =new Fire();
  f.setSeed(13);
  c.setMagic(f);
  e1.setCurrentHp(50);
  c.getState().action(c);
  Thread.sleep(4000);
  assertEquals(2,e1.getEffects().size());
  assertEquals(Burned.class,e1.getEffects().get(0).getClass());
  assertEquals(75,e1.getEffects().get(0).getAssociatedDamage());
  assertEquals(1,c.getEnemies().size());
  assertEquals(initTurn.class,c.getState().getClass());
  assertEquals(true,c.getQueue().get_queue().contains(b));
 
  //Black Mage uses Thunder on e2,should  die,and Characters Wins
  c.getQueue().get_queue().clear();
  b.equip(new Staff("",300,30,200));
  c.setActiveCharacter(b);
  c.setState(magicAttack);
  c.setTarget(e2);
  c.getMagicArray().get(1).setSeed(2994);
  c.setMagic(c.getMagicArray().get(1));//initializing Magic
  e2.setCurrentHp(30);
  c.getState().action(c);
  Thread.sleep(4000);
  assertEquals(1,e2.getParalyseCounter());
  assertEquals(0,c.getEnemies().size());
  assertEquals(true,c.doesPlayerWin());
  assertEquals(End.class,c.getState().getClass());
 
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
 
 @Test
 void end() {
 }
}