package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineerTest {
 TurnsQueue queue;
 Engineer engineer1;
 Engineer engineer2;
 Engineer engineer_name;
 Engineer engineer_defense;
 Engineer engineer_maxHp;
 Enemy enemy;

 @BeforeEach
 void setup() throws InvalidStatValueException {
  queue= new TurnsQueue();
  engineer1= new Engineer("engineer1",40,40,queue);
  engineer2= new Engineer("engineer1",40,40,queue);
  engineer_name= new Engineer("engineer3",40,40,queue);
  engineer_defense= new Engineer("engineer1",44,40,queue);
  engineer_maxHp= new Engineer("engineer1",40,44,queue);
  enemy=new Enemy("enemy1",40,40,40,queue);
 }
 
 
 @Test
 void testToString()  {
  assertEquals( "Engineer{maxHp=40, defense=40, name='engineer1'}",engineer1.toString());
 }
 
 @Test
 void testHashCode() {
  assertEquals(engineer1.hashCode(),engineer1.hashCode());
  assertEquals(engineer1.hashCode(),engineer2.hashCode());
 }
 
 @Test
 void testEquals() {
  assertTrue(engineer1.equals(engineer1));
  assertTrue(engineer1.equals(engineer2));
  assertFalse(engineer1.equals(engineer_name));
  assertFalse(engineer1.equals(engineer_defense));
  assertFalse(engineer1.equals(engineer_maxHp));
  assertFalse(engineer1.equals(enemy));
  
 }
 @Test
 void testInvalidStatException(){
  assertThrows(InvalidStatValueException.class, ()-> {new Engineer("engineer1",0,40,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new Engineer("engineer1",40,-1,queue);});
 }
}
