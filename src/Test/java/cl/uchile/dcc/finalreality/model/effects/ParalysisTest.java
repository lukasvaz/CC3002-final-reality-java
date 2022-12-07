package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ParalysisTest {
 Paralysis p;
 TurnsQueue q;
 @BeforeEach
 void setup() {
  p= new Paralysis();
  q = new TurnsQueue();
 }
 
 
 @Test
 void updateEffect() throws InterruptedException {
  Enemy e= new Enemy("",30,120,120,120,q);
  e.setEffect(p);
  e.getEffect().updateEffect(e);
  
  assertEquals(NullEffect.uniqueInstance() ,e.getEffect());
 
   Thread.sleep(5000);
 
  assertEquals(e,q.get_queue().poll());
 }
 
 }