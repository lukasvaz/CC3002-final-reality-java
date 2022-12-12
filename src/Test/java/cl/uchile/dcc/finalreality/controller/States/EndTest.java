package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.view.PrimitiveView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class EndTest {
 
 StateInterface end;
 Controller c;
 
 @BeforeEach
 void setUp(){
  c = new Controller();
  end = new End();
  
 }
 @Test
 void action() throws InvalidWeaponAssignmentException, IOException, NullWeaponException, WeaponNotInInventoryException {
  c.setView(new PrimitiveView());
  //Characters Win
  c.setState(end);
  c.defaultCharacterSelection();
  c.getState().action(c);
 
  //Enemies Win
  c.getCharacters().clear();
  c.setState(end);
  c.createRandomEnemy();
  c.getState().action(c);

 }
}