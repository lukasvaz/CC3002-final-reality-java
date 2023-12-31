package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.magic.MagicInterface;
import cl.uchile.dcc.finalreality.model.magic.Thunder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonMagicCharactersTest {
 
 @Test
  void implemetsMagicTest() {
  TurnsQueue q = new TurnsQueue();
  Thunder t = new Thunder();
  Knight k= new Knight("",20,20,q);
  Enemy e = new Enemy("",20,20,20,20,q);
  assertThrows(NotImplementsMagicException.class, ()-> k.implementsMagic (t,e));
  assertThrows(NotImplementsMagicException.class, ()-> k.implementsMagic (t,k));
 }
 
}