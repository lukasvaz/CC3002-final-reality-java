package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.controller.factories.EnemyFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.controller.factories.BlackMageFactory;
import cl.uchile.dcc.finalreality.controller.factories.KnightFactory;
import cl.uchile.dcc.finalreality.controller.factories.WhiteMageFactory;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
 Controller c;
 TurnsQueue q;
 
 KnightFactory kfac;
 EnemyFactory efac;
 @BeforeEach
 void setup() throws InvalidStatValueException {
   c= new Controller();
   q = new TurnsQueue();
   kfac = new KnightFactory();
   efac = new EnemyFactory();
 }
 
 @Test
 void createEnemy() {
  c.setFactory(efac);
  c.createRandomEnemy(q);
  //avg cases
  assertEquals(c.getEnemies().size(),1);
  assertEquals(c.getEnemies().get(0).getClass() , Enemy.class);
  c.createRandomEnemy(q);
  assertEquals(c.getEnemies().size(),2);
  assertEquals(c.getEnemies().get(1).getClass() , Enemy.class);
 }
 
 @Test
 void attack() throws InvalidWeaponAssignmentException {
  Knight k = new Knight("",100,20,q);
  Axe a = new Axe("",50,40);
  Enemy e = new Enemy("",100,100,40,40,q);
  Enemy e2 = new Enemy("",100,100,60,40,q);
  
  k.equip(a);
  c.attack(k,e);
  assertEquals(90,e.getCurrentHp());
  c.attack(k,e2);
  assertEquals(100,e2.getCurrentHp());
  c.attack(e2,k);
  assertEquals(80,k.getCurrentHp());
 }
 @Test
 void setAndIsMaxCharacter(){
  c.setMaxCharacters(1);
  c.setFactory( new KnightFactory());
  c.createCharacter(q);
  assertEquals(true,c.isMaxCharacters());
  c.setMaxCharacters(3);
  assertEquals(false,c.isMaxCharacters());
 }
 
}