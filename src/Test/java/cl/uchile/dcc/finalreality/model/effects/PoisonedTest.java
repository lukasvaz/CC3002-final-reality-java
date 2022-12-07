package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.magic.Fire;
import cl.uchile.dcc.finalreality.model.magic.Poison;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoisonedTest {
 TurnsQueue q;
 BlackMage bm;
 Enemy e;
 Enemy e2;
 Poisoned p;
 Staff s;
 
 @BeforeEach
 void setup() {
  q = new TurnsQueue();
  s= new Staff("",30,30,10);
  bm = new BlackMage("",20,50,30,q);
  e = new Enemy("",30,100,30,20,q);
  p = new Poisoned();
 }
 
 @Test
 void updateEffect() {
  p.setAsociatedDmg(10);
  p.updateEffect( e );
  assertEquals(90 , e.getCurrentHp());
 }
 
}