package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
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
  assertEquals(50,e.getWeight());
  assertEquals(40,e.getDefense());
  assertEquals("E",e.getName());
  assertEquals(100,e.getMaxHp());
  assertEquals(30,e.getAttack());
  
  // set Weight
  fac.setWeight(20);
  Enemy e2=  fac.create(q);
  assertEquals(20,e2.getWeight());
  // set Defense
  fac.setDefense(20);
  Enemy e3=  fac.create(q);
  assertEquals(20,e3.getDefense());
  
  // setting MaxHp
  fac.setMaxHp(10);
  Enemy e4= fac.create(q);
  assertEquals(10, e4.getMaxHp());
 
  // setting Defense
  fac.setDefense(10);
  Enemy e5= fac.create(q);
  assertEquals(10, e5.getDefense());
 
  // setting Name
  fac.setName("hola");
  Enemy e6= fac.create(q);
  assertEquals("hola", e6.getName());
 }
 
 
 }
 
