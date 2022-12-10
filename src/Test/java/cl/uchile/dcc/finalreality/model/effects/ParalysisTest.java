package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class ParalysisTest {
 
 Controller c;
 Paralysis p;
 Paralysis p2;
 Burned b;
 Enemy e;
 TurnsQueue q;
 @BeforeEach
 void setup() {
  p= Paralysis.uniqueInstance();
  p2= Paralysis.uniqueInstance();
  b= new Burned();
  c= new Controller();
  q = new TurnsQueue();
  e = new Enemy("",30,120,120,120,c.getQueue());
 }
 
 @Test
 void uniqueInstance() {
 assertEquals(Paralysis.uniqueInstance(),Paralysis.uniqueInstance());
 }
 
 
 @Test
 void addTo() {
  //adding paralysis
  p.addTo(e);
  assertEquals(1,e.getParalyseCounter());
  p.addTo(e);
  assertEquals(2,e.getParalyseCounter());
 
 }
 
 @Test
 void applyEffect() throws NullWeaponException, InterruptedException {
  
  //apply effect should append it to Paralyses Array
  e.setController(c);
  assertEquals(0 ,e.getParalyseCounter());
  e.setEffect(p);
  assertEquals(1 ,e.getParalyseCounter());
  p.applyEffect(e);
  assertEquals(0 ,e.getParalyseCounter());
  Thread.sleep(5000);
  assertEquals(e,c.getQueue().get_queue().poll());
 
  
  
  //apply this effect should remain orther effects
  e.setEffect(p);
  e.setEffect(b);
  assertEquals(1 ,e.getParalyseCounter());
  p.applyEffect(e);
  assertEquals(new ArrayList<EffectsInterface>(Arrays.asList(b)),e.getEffects());
  Thread.sleep(5000);
  assertEquals(e,c.getQueue().get_queue().poll());
  
  
  e.getEffects().remove(b);
  //apply effect without setting it
  assertEquals(0 ,e.getParalyseCounter());
  p.applyEffect(e);
  assertEquals(0 ,e.getParalyseCounter());
  Thread.sleep(5000);
  assertEquals(null,c.getQueue().get_queue().poll());
  
 
 }
 
 }