package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.factories.KnightFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.effects.Paralysis;
import cl.uchile.dcc.finalreality.view.PrimitiveView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class createEnemyTest {
 
 StateInterface createEnemy;
 Controller c;
 
 @BeforeEach
 void setUp(){
  c = Controller.getUniqueInstance();
  createEnemy = new createEnemy();
 }
 
 @Test
 void action() throws NullWeaponException, InterruptedException, InvalidWeaponAssignmentException, WeaponNotInInventoryException {
  c.setState(createEnemy);
  c.setView(new PrimitiveView());
 //simulate character creation  as in selecCharacter
  c.defaultCharacterSelection();
  c.defaultInventary();
  c.defaultWpnAssignment();
  //cretaEnemy.action
  c.getState().action(c);
  Thread.sleep(20000);
  assertEquals(10, c.getQueue().get_queue().size());
  for (PlayerCharacter p : c.getCharacters()) {
    assertEquals(true, c.getQueue().get_queue().contains(p));
   }
  assertEquals(initTurn.class,c.getState().getClass());
 }
 @Test
 void initTurn() {
  c.setState(createEnemy);
  createEnemy.initTurn(c);
  assertEquals(initTurn.class,c.getState().getClass());
 }
}