package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class BlackMageTest {
 TurnsQueue queue;
 BlackMage bmage1;
 BlackMage bmage2;
 BlackMage bmage_name;
 BlackMage bmage_defense;
 BlackMage bmage_maxHp;
 BlackMage bmage_maxmp;
 Enemy enemy;
 @BeforeEach
 void setup() throws InvalidStatValueException {
  queue = new TurnsQueue();
  bmage1 = new BlackMage("bmage1", 40, 40, 100, queue);
  bmage2 = new BlackMage("bmage1", 40, 40, 100, queue);
  bmage_name = new BlackMage("bmage3", 40, 40, 100, queue);
  bmage_defense = new BlackMage("bmage1", 44, 40, 100, queue);
  bmage_maxHp = new BlackMage("bmage1", 40, 44, 100, queue);
  bmage_maxmp = new BlackMage("bmage1", 40, 40, 80, queue);
  enemy = new Enemy("enemy", 40, 40, 40, queue);
 }
 
 @Test
 void testEquals()  {
  assertTrue(bmage1.equals(bmage1));
  assertTrue(bmage1.equals(bmage2));
  assertFalse(bmage1.equals(bmage_name));
  assertFalse(bmage1.equals(bmage_maxHp));
  assertFalse(bmage1.equals(bmage_defense));
  assertFalse(bmage1.equals(bmage_maxmp));
  assertFalse(bmage1.equals(enemy));
 }
 
 @Test
 void testToString()  {
 
  assertEquals("BlackMage{currentMp=100, maxMp=100, maxHp=40, defense=40, name='bmage1'}",bmage1.toString());
 }
 
 @Test
 void testHashCode() {
  assertEquals(bmage1.hashCode(),bmage1.hashCode());
  assertEquals(bmage1.hashCode(),bmage1.hashCode());
 }
 @Test
 void testinvalidexception()  {
  assertThrows(InvalidStatValueException.class, ()-> {new BlackMage("name",20,20,-100,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new BlackMage("name",20,0,100,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new BlackMage("name",-1,100,100,queue);});
 }
}