package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.factories.EngineerFactory;
import cl.uchile.dcc.finalreality.controller.factories.KnightFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.view.PrimitiveView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectCharacterTest {
 StateInterface selectCharacter;
 Controller c;
 @BeforeEach
 void setUp(){
  c = new Controller();
  selectCharacter = new SelectCharacter();
 }
 

 @Test
 void action() throws NullWeaponException, InvalidWeaponAssignmentException, WeaponNotInInventoryException {
  c=new Controller();
  c.setState( selectCharacter);
  c.setView(new PrimitiveView());
  assertEquals(SelectCharacter.class,c.getState().getClass());
  c.getState().action(c);
  
  assertNotEquals(null,c.getCharacters().get(0).getEquippedWeapon());
  assertNotEquals(null,c.getCharacters().get(1).getEquippedWeapon());
  assertNotEquals(null,c.getCharacters().get(2).getEquippedWeapon());
  assertNotEquals(null,c.getCharacters().get(3).getEquippedWeapon());
  assertNotEquals(null,c.getCharacters().get(4).getEquippedWeapon());
  assertEquals(true,c.isMaxCharacters());
  assertEquals(true,c.isMaxWeapon());
  assertEquals(createEnemy.class,c.getState().getClass());
 }
 
 @Test
 void createEnemy() {
  c.setState(selectCharacter);
  selectCharacter.createEnemy(c);
  assertEquals(createEnemy.class,c.getState().getClass());
 }
}