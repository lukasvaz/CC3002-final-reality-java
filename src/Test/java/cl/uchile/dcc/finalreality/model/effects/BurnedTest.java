package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BurnedTest {
 Controller c;
 Paralysis p;
 Burned b;
 Enemy e;
 TurnsQueue q;
 @BeforeEach
 void setup() {
  p= Paralysis.uniqueInstance();
  b= new Burned();
  q = new TurnsQueue();
  e = new Enemy("",30,120,120,120,q);
  c= new Controller();
 }
 
 @Test
 void addTo() {
  //adding Burned should be at the beginning
  e.setEffect(b);
  e.setEffect(p);
  assertEquals(new ArrayList<EffectsInterface>(Arrays.asList(b)),e.getEffects());
  assertEquals(1,e.getParalyseCounter());
 
  e.getEffects().remove(b);
  e.setParalyseCounter(0);
 }
 
 @Test
 void applyEffect() {
 //avg case
  b.setAssociatedDmg(20);
  e.setEffect(b);
  b.applyEffect(e);
  assertEquals(100,e.getCurrentHp());
 
  
 }
}