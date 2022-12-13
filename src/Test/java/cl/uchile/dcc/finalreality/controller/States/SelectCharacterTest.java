package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.factories.EngineerFactory;
import cl.uchile.dcc.finalreality.controller.factories.KnightFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.view.NullView;
import cl.uchile.dcc.finalreality.view.PrimitiveView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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
 void action() throws NullWeaponException, InvalidWeaponAssignmentException, WeaponNotInInventoryException, IOException {
  c=new Controller();
  c.setState( selectCharacter);
  c.setView(new NullView());
  assertEquals(SelectCharacter.class,c.getState().getClass());
  c.getState().action(c);
  
  assertEquals(true,c.isMaxCharacters());
  assertEquals(true,c.isMaxWeapon());
  assertEquals(createEnemy.class,c.getState().getClass());
 }
 
 @Test
 void createEnemy() {
  c.setState(selectCharacter);
  c.getState().createEnemy(c);
  assertEquals(createEnemy.class,c.getState().getClass());
 }
}