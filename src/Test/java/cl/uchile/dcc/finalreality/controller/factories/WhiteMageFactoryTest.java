package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMageFactoryTest {
 
 @Test
 void create() {
  TurnsQueue q = new TurnsQueue();
  WhiteMageFactory fac= new WhiteMageFactory();
  WhiteMage bm= fac.create(q);
  //avg case
  assertEquals(250, bm.getmaxMp());
  assertEquals("", bm.getName());
  // setting params
  fac.setMaxMp(150);
  WhiteMage bm2= fac.create(q);
  assertEquals(150, bm2.getmaxMp());
 
 }
 
 }
