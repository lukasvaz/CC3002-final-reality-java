package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackMageTest {
 
 @Test
 void testEquals() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  BlackMage bmage1= new BlackMage("bmage1",40,40,100,queue);
  BlackMage bmage2= new BlackMage("bmage1",40,40,100,queue);
  BlackMage bmage_name= new BlackMage("bmage3",40,40,100,queue);
  BlackMage bmage_defense= new BlackMage("bmage1",44,40,100,queue);
  BlackMage bmage_maxHp= new BlackMage("bmage1",40,44,100,queue);
  BlackMage bmage_maxmp= new BlackMage("bmage1",40,40,80,queue);
  Enemy enemy=new Enemy("bmage1",40,40,40,queue);
  assertTrue(bmage1.equals(bmage1));
  assertTrue(bmage1.equals(bmage2));
  assertFalse(bmage1.equals(bmage_name));
  assertFalse(bmage1.equals(bmage_maxHp));
  assertFalse(bmage1.equals(bmage_maxmp));
  assertFalse(bmage1.equals(enemy));
 }
 
 @Test
 void testToString() throws InvalidStatValueException {
  TurnsQueue queue = new TurnsQueue();
  BlackMage bmage = new BlackMage("bmage1",40,40,100,queue);
  assertEquals("BlackMage{currentMp=100, maxMp=100, maxHp=40, defense=40, name='bmage1'}",bmage.toString());
 }
 
 @Test
 void testHashCode() throws InvalidStatValueException {
  TurnsQueue queue = new TurnsQueue();
  BlackMage bmage1= new BlackMage("bmage1",40,40,100,queue);
  BlackMage bmage2= new BlackMage("bmage1",40,40,100,queue);
  assertEquals(bmage1.hashCode(),bmage1.hashCode());
  assertEquals(bmage1.hashCode(),bmage1.hashCode());
 }
}