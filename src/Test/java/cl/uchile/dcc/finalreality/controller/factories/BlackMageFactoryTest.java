package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackMageFactoryTest {
 TurnsQueue q;
 BlackMageFactory fac;
 @BeforeEach
 void setUp() {
  q=new TurnsQueue();
  fac=new BlackMageFactory();
  
 }
 
 @Test
 void create() {
  BlackMage bm= fac.create(q);
  //avg case
  assertEquals(120, bm.getmaxMp());
  assertEquals("BM", bm.getName());
  assertEquals(100, bm.getMaxHp());
  assertEquals(30, bm.getDefense());
  
  // setting MaxMp
  fac.setMaxMp(10);
  BlackMage bm2= fac.create(q);
  assertEquals(10, bm2.getmaxMp());
  
  // setting MaxHp
  fac.setMaxHp(10);
  BlackMage bm3= fac.create(q);
  assertEquals(10, bm3.getMaxHp());
  
  // setting Defense
  fac.setDefense(10);
  BlackMage bm4= fac.create(q);
  assertEquals(10, bm4.getDefense());
 
  // setting Name
  fac.setName("hola");
  BlackMage bm5= fac.create(q);
  assertEquals("hola", bm5.getName());
 }
}