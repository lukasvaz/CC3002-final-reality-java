package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.controller.States.selectEnemy;
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
 void Move() throws IOException, InvalidWeaponAssignmentException, WeaponNotInInventoryException {
  c.setView(new PrimitiveView());
  c.setFactory( new KnightFactory());
  c.defaultInventary();
  GameCharacter k = c.getFactory().create(c.getQueue());
  c.setActiveCharacter(k);
  //1 input
  c.setPlayer(new Player("0"));
  c.getPlayer().move(c);
  assertEquals("0",c.getUserInput());
  //multilpleinput
  c.setPlayer(new Player("0\n3"));
  c.getPlayer().move(c);
  assertEquals("0", c.getUserInput());
  c.getPlayer().move(c);
  assertEquals("3", c.getUserInput());

  //null
  c.setPlayer(new Player(""));
  c.getPlayer().move(c);
  assertEquals(null, c.getUserInput());
 
 
 }
 
 
}