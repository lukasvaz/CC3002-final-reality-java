package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightFactoryTest {
 
 @Test
 void uniqueInstance() {
 }
 
 @Test
 void create() {
   TurnsQueue q = new TurnsQueue();
   KnightFactory fac = new KnightFactory();
   Knight knight =  fac.create(q);
   assertEquals(1,knight.getCurrentHp());
   assertEquals(1,knight.getDefense());
   assertEquals("",knight.getName());
  }
 }
