package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ParalysisTest {
 Paralysis p;
 Enemy e;
 TurnsQueue q;
 @BeforeEach
 void setup() {
  p= new Paralysis();
  q = new TurnsQueue();
  e = new Enemy("",30,120,120,120,q);
 }
 
 @Test
 void uniqueInstance() {
 assertEquals(Paralysis.uniqueInstance(),Paralysis.uniqueInstance());
 
 }
 
 @Test
 void updateEffect() throws InterruptedException {

 }
 
 }