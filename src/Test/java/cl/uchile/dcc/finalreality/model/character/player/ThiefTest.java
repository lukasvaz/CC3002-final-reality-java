package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThiefTest {
 
 
 ThiefTest() throws InvalidStatValueException {
 }
 
 @Test
 void testHashCode() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  Thief thief1= new Thief("thief1",40,40,queue);
  Thief thief2= new Thief("thief1",40,40,queue);
  assertEquals(thief1.hashCode(), thief1.hashCode());
  assertEquals(thief1.hashCode(), thief2.hashCode());
 
 }
 
 @Test
 void testEquals() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  Thief thief1= new Thief("thief1",40,40,queue);
  Thief thief2= new Thief("thief1",40,40,queue);
  Thief thief_name= new Thief("thief3",40,40,queue);
  Thief thief_defense= new Thief("thief1",44,40,queue);
  Thief thief_maxHp= new Thief("thief1",40,44,queue);
  Enemy enemy=new Enemy("enemy1",40,40,40,queue);
  assertTrue(thief1.equals(thief1));
  assertTrue(thief1.equals(thief2));
  assertFalse(thief1.equals(thief_name));
  assertFalse(thief1.equals(thief_defense));
  assertFalse(thief1.equals(thief_maxHp));
  assertFalse(thief1.equals(enemy));
 }
 
 @Test
 void testToString() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  Thief thief1= new Thief("thief1",40,40,queue);
  assertEquals("Thief{maxHp=40, defense=40, name='thief1'}",thief1.toString());
 }
}