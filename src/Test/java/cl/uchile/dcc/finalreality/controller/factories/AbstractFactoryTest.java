package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryTest {
 KnightFactory fac;
 TurnsQueue q;
 @BeforeEach
 void setUp() {
 fac = new KnightFactory();
 q = new TurnsQueue();
 }
 
 @Test
 void settersTest() {
  Knight knight =  fac.create(q);
  assertEquals(1,knight.getCurrentHp());
  assertEquals(1,knight.getDefense());
  assertEquals("",knight.getName());
  //set name
  fac.setName("hola");
  Knight knight2 =  fac.create(q);
  assertEquals("hola",knight2.getName());
  // set Defense
  fac.setDefense(100);
  Knight knight3 =  fac.create(q);
  assertEquals(100,knight3.getDefense());
  
  // set maxHp
  fac.setMaxHp(150);
  Knight knight4 =  fac.create(q);
  assertEquals(150,knight4.getMaxHp());
 
 }
 
}