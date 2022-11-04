package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
 
 @Test
 void testToString() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  Knight knight1= new Knight("knight1",40,40,queue);
  assertEquals("Knight{maxHp=40, defense=40, name='knight1'}",knight1.toString());
 
 }
 
 @Test
 void testHashCode() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  Knight knight1= new Knight("knight1",40,40,queue);
  Knight knight2= new Knight("knight1",40,40,queue);
  assertEquals(knight1.hashCode(), knight1.hashCode());
  assertEquals(knight1.hashCode(), knight2.hashCode());
 
 }
 
 @Test
 void testEquals() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  Knight knight1= new Knight("knight1",40,40,queue);
  Knight knight2= new Knight("knight1",40,40,queue);
  Knight knight_name= new Knight("knight3",40,40,queue);
  Knight knight_defense= new Knight("knight1",44,40,queue);
  Knight knight_maxHp= new Knight("knight1",40,44,queue);
  Enemy enemy=new Enemy("enemy",40,40,40,queue);
  assertTrue(knight1.equals(knight1));
  assertTrue(knight1.equals(knight2));
  assertFalse(knight1.equals(knight_name));
  assertFalse(knight1.equals(knight_defense));
  assertFalse(knight1.equals(knight_maxHp));
  assertFalse(knight1.equals(enemy));
 }
}