package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThiefTest {
 TurnsQueue queue;
 Thief thief1;
 Thief thief2;
 Thief thief_name;
 Thief thief_defense;
 Thief thief_maxHp;
 Enemy enemy;
 
 @BeforeEach
 void setup() throws InvalidStatValueException {
  queue= new TurnsQueue();
  thief1= new Thief("thief1",40,40,queue);
  thief2= new Thief("thief1",40,40,queue);
  thief_name = new Thief("thief3", 40, 40, queue);
  thief_defense = new Thief("thief1", 44, 40, queue);
  thief_maxHp = new Thief("thief1", 40, 44, queue);
  enemy = new Enemy("enemy1", 40, 40, 40, queue);
 }
 
 @Test
 void testHashCode() {
  assertEquals(thief1.hashCode(), thief1.hashCode());
  assertEquals(thief1.hashCode(), thief2.hashCode());
 
 }
 
 @Test
 void testEquals()  {
  assertTrue(thief1.equals(thief1));
  assertTrue(thief1.equals(thief2));
  assertFalse(thief1.equals(thief_name));
  assertFalse(thief1.equals(thief_defense));
  assertFalse(thief1.equals(thief_maxHp));
  assertFalse(thief1.equals(enemy));
 }
 
 @Test
 void testToString()  {
  assertEquals("Thief{maxHp=40, defense=40, name='thief1'}",thief1.toString());
 }
 @Test
 void testInvalidStatException() throws InvalidStatValueException {
  assertThrows(InvalidStatValueException.class, ()-> {new Thief("thirf1",0,40,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new Thief("thirf1",40,-1,queue);});
 }
}