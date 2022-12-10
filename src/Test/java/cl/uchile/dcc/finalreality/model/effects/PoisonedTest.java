package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.magic.Fire;
import cl.uchile.dcc.finalreality.model.magic.Poison;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PoisonedTest {
 TurnsQueue q;
 BlackMage bm;
 Enemy e;
 Enemy e2;
 Poisoned p;
 Poisoned p2;
 Burned b;
 Paralysis paralysis;
 Staff s;
 
 @BeforeEach
 void setup() {
  q = new TurnsQueue();
  s= new Staff("",30,30,10);
  bm = new BlackMage("",20,50,30,q);
  e = new Enemy("",30,100,30,20,q);
  p = new Poisoned();
  b = new Burned();
  p2 = new Poisoned();
 paralysis = new Paralysis();
 }
 
 
 @Test
 void updateEffect() {
  //avg case
  e.setEffect(p);
  p.setAssociatedDmg(20);
  p.applyEffect(e);
  assertEquals(80,e.getCurrentHp());
 }
 @Test
 void addTo() {
  //add Poisoned
  e.setEffect(b);
  e.setEffect(p);
  e.setEffect(paralysis);
  assertEquals(new ArrayList<EffectsInterface>(Arrays.asList(p,b)),e.getEffects());
  assertEquals(1,e.getParalyseCounter());
  
  e.getEffects().remove(p);
  e.getEffects().remove(b);
  e.setParalyseCounter(0);
  
  
 }
}