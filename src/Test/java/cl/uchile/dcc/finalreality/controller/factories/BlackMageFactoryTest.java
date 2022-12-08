package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackMageFactoryTest {
 
 @Test
 void create() {
  TurnsQueue q = new TurnsQueue();
  BlackMageFactory fac= new BlackMageFactory();
  BlackMage bm= fac.create(q);
  //avg case
  assertEquals(200, bm.getmaxMp());
  assertEquals("", bm.getName());
  // setting params
  fac.setMaxMp(250);
  BlackMage bm2= fac.create(q);
  assertEquals(250, bm2.getmaxMp());
  
 }
}