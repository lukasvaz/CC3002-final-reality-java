package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.Player;
import cl.uchile.dcc.finalreality.controller.factories.ThiefFactory;
import cl.uchile.dcc.finalreality.controller.factories.WhiteMageFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.view.NullView;
import cl.uchile.dcc.finalreality.view.PrimitiveView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SelectMagicTest {
 
 StateInterface selectMagic;
 Controller c;
 
 @BeforeEach
 void setUp(){
  c = new Controller();
  selectMagic= new SelectMagic();
 }
 @Test
 void action() throws InvalidWeaponAssignmentException, IOException, NullWeaponException, WeaponNotInInventoryException {
  c.setState(selectMagic);
  c.setView(new NullView());
  c.defaultMagicArray();
  System.out.println(c.getMagicArray());
  c.setFactory(new WhiteMageFactory());
  PlayerCharacter w = c.createCharacter();
  c.setActiveCharacter(w);
  //select Magic (Heal) then go to magicAttack
  c.setPlayer(new Player("4\n3\nMagicAttack"));
  c.getState().action(c);
  assertEquals(c.getMagicArray().get(3),c.getMagic());
  assertEquals(MagicAttack.class,c.getState().getClass());
  //select Magic then goes to Attack
  c.setState(selectMagic);
  c.setPlayer(new Player("1\n0\nAttack"));
  c.getState().action(c);
  assertEquals(c.getMagicArray().get(0),c.getMagic());
  //select Magix then selectEnemies
  c.setState(selectMagic);
  c.setPlayer(new Player("1\n0\n3\nEnemy"));
  c.getState().action(c);
  assertEquals(c.getMagicArray().get(3),c.getMagic());
  assertEquals(selectEnemy.class,c.getState().getClass());
  //wrong input do nothing then  change to MagicAttack
  c.setState(selectMagic);
  c.setPlayer(new Player("2\nhola\nWeapon"));
  c.getState().action(c);
  assertEquals(c.getMagicArray().get(2),c.getMagic());
  assertEquals(SelectWeapon.class,c.getState().getClass());
 
 }
 
 @Test
 void updateState() {
  c.setState(selectMagic);
  c.setUserInput("Magic");
  c.getState().updateState(c);
  assertEquals(SelectMagic.class,c.getState().getClass());
 
 }
 
 
 @Test
 void selectWeapon() {
   c.setState(selectMagic);
   c.getState().selectWeapon(c);
   assertEquals(SelectWeapon.class,c.getState().getClass());
 }
 
 @Test
 void attack() {
  c.setState(selectMagic);
  c.getState().Attack(c);
  assertEquals(Attack.class,c.getState().getClass());
 }
 
 @Test
 void selectEnemy() {
  c.setState(selectMagic);
  c.getState().selectEnemy(c);
  assertEquals(selectEnemy.class,c.getState().getClass());
 }
 
 @Test
 void magicAttack() {
   c.setState(selectMagic);
   c.getState().magicAttack(c);
   assertEquals(MagicAttack.class,c.getState().getClass());
 }
}