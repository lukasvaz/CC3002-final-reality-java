package cl.uchile.dcc.finalreality.model.magic;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NotEnughMpException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.effects.NullEffect;
import cl.uchile.dcc.finalreality.model.effects.Paralysis;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealTest  {
 
 @Test
 void magicOn() throws InvalidWeaponAssignmentException, NotEnughMpException {
  TurnsQueue q = new TurnsQueue();
  Staff s= new Staff("",30,30,10);
  WhiteMage wm = new WhiteMage("",20,50,30,q);
  wm.equip(s);
  Knight k = new Knight("",100,100,q);
  //avg case
  k.setCurrentHp(20);
  Heal h = new Heal();
  h.magicOn( wm,k);
  assertEquals(50,k.getCurrentHp());
  assertEquals(15,wm.getcurrentMp());
  
  //hp=maxhp
  wm.setCurrentMp(15);
  k.setCurrentHp(k.getMaxHp());
  h.magicOn( wm,k);
  assertEquals(k.getMaxHp(),k.getCurrentHp());
  assertEquals(0,wm.getcurrentMp());
  
  //mp=0
  wm.setCurrentMp(0);
  k.setCurrentHp(10);
  assertThrows(NotEnughMpException.class,()->h.magicOn(wm,k));
  
 }
 
}

