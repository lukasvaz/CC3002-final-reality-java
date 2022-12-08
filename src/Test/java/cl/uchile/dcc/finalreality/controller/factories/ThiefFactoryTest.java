package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThiefFactoryTest {
 
 @Test
 void create() {
   TurnsQueue q = new TurnsQueue();
   EngineerFactory fac = new EngineerFactory();
   Engineer eng =  fac.create(q);
   assertEquals(1,eng.getCurrentHp());
   assertEquals(1,eng.getDefense());
   assertEquals("",eng.getName());
 }
}