package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyFactoryTest {
 
 EnemyFactory fac;
 TurnsQueue q;
 @BeforeEach
 void setUp() {
  fac = new EnemyFactory();
  q = new TurnsQueue();}
 
 @Test
 void settersTest() {
  Enemy e=  fac.create(q);
  assertEquals(1,e.getWeight());
  assertEquals(1,e.getDefense());
  // set Weight
  fac.setWeight(20);
  Enemy e2=  fac.create(q);
  assertEquals(20,e2.getWeight());
  // set Defense
  fac.setDefense(20);
  Enemy e3=  fac.create(q);
  assertEquals(20,e3.getDefense());
 
 
 }
 }
