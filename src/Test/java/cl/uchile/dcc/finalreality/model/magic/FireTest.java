package cl.uchile.dcc.finalreality.model.magic;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NotEnughMpException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.effects.Burned;
import cl.uchile.dcc.finalreality.model.effects.EffectsInterface;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FireTest {
 TurnsQueue q;
 BlackMage bm;
 Enemy e;
 Enemy e2;
 Fire f;
 Staff s;
 
 @BeforeEach
 void setup() {
  q = new TurnsQueue();
  s= new Staff("",30,30,10);
  bm = new BlackMage("",20,50,30,q);
  e = new Enemy("",30,100,30,20,q);
  f = new Fire();
  
 }
 @Test
 void magicOn() throws InvalidWeaponAssignmentException, NotEnughMpException {
 
  bm.equip(s);
  f.setSeed(100);
  ArrayList<EffectsInterface> old=e.getEffects();
  f.magicOn( bm,e);
  //avg case not Effect
  assertEquals(90,e.getCurrentHp());
  assertEquals(15,bm.getcurrentMp());
  assertEquals(old,e.getEffects());
  
  // avg case burn effect
  bm.setCurrentMp(30);
  e.setCurrentHp(e.getMaxHp());
  f.setSeed(172);
  f.magicOn( bm,e);
  assertEquals(Burned.class,e.getEffects().get(0).getClass());
 
  // hp to 0
  bm.setCurrentMp(30);
  e.setCurrentHp(1);
  f.magicOn(bm,e);
  assertEquals(0,e.getCurrentHp());
  
  //mp<15
  bm.setCurrentMp(1);
  assertThrows(NotEnughMpException.class ,()->f.magicOn(bm,e));
 //hp=0
  bm.setCurrentMp(30);
  e.setCurrentHp(0);
  f.magicOn(bm,e);
  assertEquals(0,e.getCurrentHp());
 
 }
 }
