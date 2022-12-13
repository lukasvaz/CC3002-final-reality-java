package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightFactoryTest {
 KnightFactory fac;
 TurnsQueue q;
 
 
 @BeforeEach
 void setUp() {
  fac = new KnightFactory();
  q = new TurnsQueue();}
 
 @Test
 void create() {
   TurnsQueue q = new TurnsQueue();
   KnightFactory fac = new KnightFactory();
   Knight knight =  fac.create(q);
   assertEquals(150,knight.getCurrentHp());
   assertEquals(50,knight.getDefense());
   assertEquals("Knight",knight.getName());
 
  // set Defense
  fac.setDefense(20);
  Knight e3=  fac.create(q);
  assertEquals(20,e3.getDefense());
 
  // setting MaxHp
  fac.setMaxHp(10);
  Knight e4= fac.create(q);
  assertEquals(10, e4.getMaxHp());
 
  // setting Defense
  fac.setDefense(10);
  Knight e5= fac.create(q);
  assertEquals(10, e5.getDefense());
 
  // setting Name
  fac.setName("hola");
  Knight e6= fac.create(q);
  assertEquals("hola", e6.getName());
 
 
 
 }
 }
