package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
 TurnsQueue queue;
 Knight knight1;
 Knight knight2;
 Knight knight_name;
 Knight knight_defense;
 Knight knight_maxHp;
 Enemy enemy;
 @BeforeEach
 void setup() throws InvalidStatValueException {
  queue= new TurnsQueue();
  knight1= new Knight("knight1",40,40,queue);
  knight2= new Knight("knight1",40,40,queue);
  knight_name= new Knight("knight3",40,40,queue);
  knight_defense= new Knight("knight1",44,40,queue);
  knight_maxHp= new Knight("knight1",40,44,queue);
  enemy=new Enemy("enemy",40,40,40,10,queue);
  
 }
 @Test
 void testToString()  {
  assertEquals("Knight{maxHp=40, defense=40, name='knight1'}",knight1.toString());
 
 }
 
 @Test
 void testHashCode(){
  assertEquals(knight1.hashCode(), knight1.hashCode());
  assertEquals(knight1.hashCode(), knight2.hashCode());
 
 }
 
 @Test
 void testEquals() {
  assertTrue(knight1.equals(knight1));
  assertTrue(knight1.equals(knight2));
  assertFalse(knight1.equals(knight_name));
  assertFalse(knight1.equals(knight_defense));
  assertFalse(knight1.equals(knight_maxHp));
  assertFalse(knight1.equals(enemy));
 }
 @Test
 void testInvalidStatException() {
  assertThrows(InvalidStatValueException.class, ()-> {new Knight("knigh1",0,40,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new Knight("knight1",40,-1,queue);});
 }
}