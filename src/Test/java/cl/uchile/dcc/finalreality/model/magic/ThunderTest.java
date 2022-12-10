package cl.uchile.dcc.finalreality.model.magic;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NotEnughMpException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.effects.EffectsInterface;
import cl.uchile.dcc.finalreality.model.effects.Paralysis;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
  ArrayList<EffectsInterface> old = new ArrayList<>();
  t.setSeed(1);
  //avg case not  Aplied Effect
  t.magicOn( bm,e);
  assertEquals(90,e.getCurrentHp());
  assertEquals(15,bm.getcurrentMp());
  assertEquals(1,e.getParalyseCounter());
  e.setParalyseCounter(0);
  
  //avg case not Aplied Effect
  bm.setCurrentMp(15);
  t.setSeed(14);
  t.magicOn( bm,e);
  assertEquals(0,e.getParalyseCounter());
  
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