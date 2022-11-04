package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineerTest {
 
 
 @Test
 void testToString() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  Engineer engineer1= new Engineer("engineer1",40,40,queue);
  assertEquals( "Engineer{maxHp=40, defense=40, name='engineer1'}",engineer1.toString());
 }
 
 @Test
 void testHashCode() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  Engineer engineer1= new Engineer("engineer1",40,40,queue);
  Engineer engineer2= new Engineer("engineer1",40,40,queue);
  assertEquals(engineer1.hashCode(),engineer1.hashCode());
  assertEquals(engineer1.hashCode(),engineer2.hashCode());
 }
 
 @Test
 void testEquals() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  Engineer engineer1= new Engineer("engineer1",40,40,queue);
  Engineer engineer2= new Engineer("engineer1",40,40,queue);
  Engineer engineer_name= new Engineer("engineer3",40,40,queue);
  Engineer engineer_defense= new Engineer("engineer1",44,40,queue);
  Engineer engineer_maxHp= new Engineer("engineer1",40,44,queue);
  Enemy enemy=new Enemy("enemy1",40,40,40,queue);
  assertTrue(engineer1.equals(engineer1));
  assertTrue(engineer1.equals(engineer2));
  assertFalse(engineer1.equals(engineer_name));
  assertFalse(engineer1.equals(engineer_defense));
  assertFalse(engineer1.equals(engineer_maxHp));
  assertFalse(engineer1.equals(enemy));
  
 }
}