package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineerFactoryTest {
 
 EngineerFactory fac;
 TurnsQueue q;
 
 @BeforeEach
 void setUp() {
  fac = new EngineerFactory();
  q = new TurnsQueue();}
 
 @Test
 void create() {
  Engineer eng =  fac.create(q);
  assertEquals(150,eng.getCurrentHp());
  assertEquals(80,eng.getDefense());
  assertEquals("Engineer",eng.getName());
 
 
  // set Defense
  fac.setDefense(20);
  Engineer e3=  fac.create(q);
  assertEquals(20,e3.getDefense());
 
  // setting MaxHp
  fac.setMaxHp(10);
  Engineer e4= fac.create(q);
  assertEquals(10, e4.getMaxHp());
 
  // setting Defense
  fac.setDefense(10);
  Engineer e5= fac.create(q);
  assertEquals(10, e5.getDefense());
 
  // setting Name
  fac.setName("hola");
  Engineer e6= fac.create(q);
  assertEquals("hola", e6.getName());
  
  
 }
}