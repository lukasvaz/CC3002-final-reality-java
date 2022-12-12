package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.Player;
import cl.uchile.dcc.finalreality.controller.factories.EngineerFactory;
import cl.uchile.dcc.finalreality.controller.factories.WhiteMageFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.view.PrimitiveView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MagicCharacterTurnTest {
 StateInterface magicCharacterTurn;
 Controller c;
 
 @BeforeEach
 void setUp(){
  c = new Controller();
  magicCharacterTurn = new MagicCharacterTurn();
 }
 
 @Test
 void action() throws InvalidWeaponAssignmentException, IOException, NullWeaponException, WeaponNotInInventoryException {
  c.setState(magicCharacterTurn);
  c.setView(new PrimitiveView());
  c.setFactory(new WhiteMageFactory());
  PlayerCharacter w =c.createCharacter();
  c.setActiveCharacter(w);
  c.defaultInventary();
  c.setPlayer(new Player("Magic"));
  //Select magic option
  c.getState().action(c);
 
 }
}