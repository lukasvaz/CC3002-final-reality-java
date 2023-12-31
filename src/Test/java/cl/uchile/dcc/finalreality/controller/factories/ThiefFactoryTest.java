package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThiefFactoryTest {
 
 ThiefFactory fac;
 TurnsQueue q;
 
 
 @BeforeEach
 void setUp() {
  fac = new ThiefFactory();
  q = new TurnsQueue();}
 
 
 @Test
 void create() {
   Thief eng =  fac.create(q);
   assertEquals(150,eng.getCurrentHp());
   assertEquals(70,eng.getDefense());
   assertEquals("Thief",eng.getName());
   
  // set Defense
  fac.setDefense(20);
  Thief e3=  fac.create(q);
  assertEquals(20,e3.getDefense());
 
  // setting MaxHp
  fac.setMaxHp(10);
  Thief e4= fac.create(q);
  assertEquals(10, e4.getMaxHp());
 
  // setting Defense
  fac.setDefense(10);
  Thief e5= fac.create(q);
  assertEquals(10, e5.getDefense());
 
  // setting Name
  fac.setName("hola");
  Thief e6= fac.create(q);
  assertEquals("hola", e6.getName());
 
 
 }
}