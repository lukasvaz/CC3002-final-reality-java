package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMageFactoryTest {
 
 TurnsQueue q;
 WhiteMageFactory fac;
 @BeforeEach
 void setUp() {
  q=new TurnsQueue();
  fac=new WhiteMageFactory();
  
 }
 
 @Test
 void create() {
  WhiteMage bm= fac.create(q);
  //avg case
  assertEquals(200, bm.getmaxMp());
  assertEquals("WhiteMage", bm.getName());
  assertEquals(180, bm.getMaxHp());
  assertEquals(50, bm.getDefense());
  
  // setting MaxMp
  fac.setMaxMp(10);
  WhiteMage bm2= fac.create(q);
  assertEquals(10, bm2.getmaxMp());
  
  // setting MaxHp
  fac.setMaxHp(10);
  WhiteMage bm3= fac.create(q);
  assertEquals(10, bm3.getMaxHp());
  
  // setting Defense
  fac.setDefense(10);
  WhiteMage bm4= fac.create(q);
  assertEquals(10, bm4.getDefense());
  
  // setting Name
  fac.setName("hola");
  WhiteMage bm5= fac.create(q);
  assertEquals("hola", bm5.getName());
 }
 }
