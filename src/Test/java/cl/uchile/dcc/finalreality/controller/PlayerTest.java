package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.controller.States.CharacterTurn;
import cl.uchile.dcc.finalreality.controller.factories.KnightFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.view.PrimitiveView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
 Controller c;
 
 @BeforeEach
 void setUp(){
  c= new Controller();
 }
 
 @Test
 void selectWeaponMove() throws IOException, InvalidWeaponAssignmentException, WeaponNotInInventoryException {
  c.setView(new PrimitiveView());
  c.setState(new CharacterTurn());
  c.setFactory( new KnightFactory());
  c.defaultInventary();
  GameCharacter k = c.getFactory().create(c.getQueue());
  c.setActiveCharacter(k);
  //State: CharacterTurn
  c.setPlayer(new Player("0"));
  c.getPlayer().selectWeaponMove(c);
  assertEquals(Axe.class, ((PlayerCharacter)c.getActiveCharacter()).getEquippedWeapon().getClass());
  //Knight equips Axe, read only first line
  c.setPlayer(new Player("0\n3"));
  c.getPlayer().selectWeaponMove(c);
  assertEquals(Axe.class, ((PlayerCharacter)c.getActiveCharacter()).getEquippedWeapon().getClass());
  //Knight equips Axe, read only first line
  c.setPlayer(new Player("0\n3"));
  c.getPlayer().selectWeaponMove(c);
  assertEquals(Axe.class, ((PlayerCharacter)c.getActiveCharacter()).getEquippedWeapon().getClass());
  //prints
  c.setPlayer(new Player("10"));
  c.getPlayer().selectWeaponMove(c);
  c.setPlayer(new Player("1"));
  c.getPlayer().selectWeaponMove(c);
 
  c.setPlayer(new Player("holaa"));
  c.getPlayer().selectWeaponMove(c);
 }
 
 @Test
 void selectCharacterMove() {
 }
 
 @Test
 void selectEnemyMove() {
 }
 
 @Test
 void ok() throws IOException {
  //direct ok
  Player p = new Player("ok");
  assertEquals(true,p.ok());
 //after one try
  Player p2 = new Player("1\nok");
  assertEquals(false,p2.ok());
  assertEquals(true,p2.ok());
 }
 
}