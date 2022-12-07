package cl.uchile.dcc.finalreality.model.magic;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NotEnughMpException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.effects.NullEffect;
import cl.uchile.dcc.finalreality.model.effects.Poisoned;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoisonTest {
 
 @Test
 void magicOn() throws InvalidWeaponAssignmentException, NotEnughMpException {
  TurnsQueue q = new TurnsQueue();
  Staff s= new Staff("",30,30,10);
  WhiteMage wm = new WhiteMage("",20,50,50,q);
  wm.equip(s);
  Enemy e = new Enemy("",20,100,30,10,q);
  Poison p = new Poison();
  
  // avg case
  assertEquals(NullEffect.class,e.getEffect().getClass());
  p.magicOn(wm,e);
  assertEquals(100,e.getCurrentHp());
  assertEquals(10,wm.getcurrentMp());
  assertEquals(Poisoned.class , e.getEffect().getClass());
  
  //mp=0
  wm.setCurrentMp(0);
  assertThrows(NotEnughMpException.class,()->p.magicOn(wm,e));
  
 }
}