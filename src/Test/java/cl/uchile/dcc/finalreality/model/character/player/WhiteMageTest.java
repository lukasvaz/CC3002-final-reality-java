package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMageTest {
 
 @Test
 void testEquals() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  WhiteMage wmage1= new WhiteMage("wmage1",40,40,100,queue);
  WhiteMage wmage2= new WhiteMage("wmage1",40,40,100,queue);
  WhiteMage wmage_name= new WhiteMage("wmage3",40,40,100,queue);
  WhiteMage wmage_defense= new WhiteMage("wmage1",44,40,100,queue);
  WhiteMage wmage_maxHp= new WhiteMage("wmage1",40,44,100,queue);
  WhiteMage wmage_maxmp= new WhiteMage("wmage1",40,40,80,queue);
  Enemy enemy=new Enemy("enemy",40,40,40,queue);
  assertTrue(wmage1.equals(wmage1));
  assertTrue(wmage1.equals(wmage2));
  assertFalse(wmage1.equals(wmage_name));
  assertFalse(wmage1.equals(wmage_maxHp));
  assertFalse(wmage1.equals(wmage_maxmp));
  assertFalse(wmage1.equals(enemy));
 }
 
 @Test
 void testHashCode() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  WhiteMage wmage1= new WhiteMage("wmage1",40,40,100,queue);
  WhiteMage wmage2= new WhiteMage("wmage1",40,40,100,queue);
  assertEquals(wmage1.hashCode(),wmage1.hashCode());
  assertEquals(wmage1.hashCode(),wmage1.hashCode());
  
 }
 
 @Test
 void testToString() throws InvalidStatValueException {
  TurnsQueue queue = new TurnsQueue();
  WhiteMage wmage = new WhiteMage("wmage1",40,40,100,queue);
  assertEquals("WhiteMage{currentMp=100, maxMp=100, maxHp=40, defense=40, name='wmage1'}",wmage.toString());
 }
}