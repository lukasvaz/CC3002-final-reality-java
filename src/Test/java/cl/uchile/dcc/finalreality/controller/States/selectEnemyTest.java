package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.Player;
import cl.uchile.dcc.finalreality.controller.factories.KnightFactory;
import cl.uchile.dcc.finalreality.controller.factories.ThiefFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.view.PrimitiveView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class selectEnemyTest {
 
 StateInterface selectEnemy;
 Controller c;
 
 @BeforeEach
 void setUp(){
  c = new Controller();
  selectEnemy= new selectEnemy();
 }
 
 @Test
 void action() throws InvalidWeaponAssignmentException, IOException, NullWeaponException, WeaponNotInInventoryException {
  c.setState(selectEnemy);
  c.setView(new PrimitiveView());
  Enemy e1=c.createRandomEnemy();
  Enemy e2=c.createRandomEnemy();
  c.defaultInventary();
  c.setFactory(new ThiefFactory());
  PlayerCharacter t = c.createCharacter();
  c.setActiveCharacter(t);
  //select enemies then attacks
  c.setPlayer(new Player("0\n1\nAttack"));
  c.getState().action(c);
  assertEquals(e2,c.getTarget());
  assertEquals(Attack.class,c.getState().getClass());
  //select enemies then selectMagic
  c.setState(selectEnemy);
  c.setPlayer(new Player("1\n0\nMagic"));
  c.getState().action(c);
  assertEquals(e1,c.getTarget());
  assertEquals(SelectMagic.class,c.getState().getClass());
  //select enemies then selectWeapon
  c.setState(selectEnemy);
  c.setPlayer(new Player("1\n0\nWeapon"));
  c.getState().action(c);
  assertEquals(e1,c.getTarget());
  assertEquals(SelectWeapon.class,c.getState().getClass());
  //wrong input do nothing then  change to MagicAttack
  c.setState(selectEnemy);
  c.setPlayer(new Player("0\nhola\nMagicAttack"));
  c.getState().action(c);
  assertEquals(e1,c.getTarget());
  assertEquals(MagicAttack.class,c.getState().getClass());
 
 
 }
 
 @Test
 void updateState() {
  c.setState(selectEnemy);
  c.setUserInput("Enemy");
  c.getState().updateState(c);
  assertEquals(selectEnemy.class,c.getState().getClass());
 
 }
 
 @Test
 void Attack() {
  c.setState(selectEnemy);
  c.getState().Attack(c);
  assertEquals(Attack.class,c.getState().getClass());
 }
 @Test
 void MagicAttack() {
  c.setState(selectEnemy);
  c.getState().magicAttack(c);
  assertEquals(MagicAttack.class,c.getState().getClass());
 }
 
 @Test
 void Weapon() {
  c.setState(selectEnemy);
  c.getState().selectWeapon(c);
  assertEquals(SelectWeapon.class,c.getState().getClass());
 }
 
 @Test
 void Magic() {
  c.setState(selectEnemy);
  c.getState().selectMagic(c);
  assertEquals(SelectMagic.class,c.getState().getClass());
 }
 
}