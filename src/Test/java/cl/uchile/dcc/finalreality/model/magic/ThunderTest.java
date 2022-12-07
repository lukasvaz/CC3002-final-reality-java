package cl.uchile.dcc.finalreality.model.magic;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NotEnughMpException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.effects.NullEffect;
import cl.uchile.dcc.finalreality.model.effects.Paralysis;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ThunderTest {
 
 @Test
 void magicOn() throws InvalidWeaponAssignmentException, NotEnughMpException {
  
  
  TurnsQueue q = new TurnsQueue();
  Staff s= new Staff("",30,30,10);
  BlackMage bm = new BlackMage("",20,50,30,q);
  bm.equip(s);
  Enemy e = new Enemy("",30,100,30,20,q);
  Thunder t = new Thunder();
  t.setSeed(100);
  //avg case Not Aplied Effect
  t.magicOn( bm,e);
  assertEquals(90,e.getCurrentHp());
  assertEquals(15,bm.getcurrentMp());
  assertEquals(NullEffect.uniqueInstance(),e.getEffect());
  
  
  //avg case Aplied Effect
  bm.setCurrentMp(15);
  t.setSeed(102);
  t.magicOn( bm,e);
  assertEquals(Paralysis.uniqueInstance(),e.getEffect());
  
  //not enoughMp
  bm.setCurrentMp(14);
 assertThrows(NotEnughMpException.class , ()->  t.magicOn( bm,e));
 
  //hp=0
  bm.setCurrentMp(15);
  e.setCurrentHp(0);
  t.magicOn( bm,e);
  assertEquals(0,e.getCurrentHp());
  
 }
}