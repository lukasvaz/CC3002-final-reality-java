package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.controller.factories.EnemyFactory;
import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.controller.factories.BlackMageFactory;
import cl.uchile.dcc.finalreality.controller.factories.KnightFactory;
import cl.uchile.dcc.finalreality.controller.factories.WhiteMageFactory;
import cl.uchile.dcc.finalreality.model.effects.Paralysis;
import cl.uchile.dcc.finalreality.model.effects.Poisoned;
import cl.uchile.dcc.finalreality.model.magic.BlackMagic;
import cl.uchile.dcc.finalreality.model.magic.Poison;
import cl.uchile.dcc.finalreality.model.magic.Thunder;
import cl.uchile.dcc.finalreality.model.magic.WhiteMagic;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
 Controller c;
 Knight k;
 KnightFactory kfac;
 EnemyFactory efac;
 Enemy e;
 WhiteMageFactory wmfac;
 BlackMageFactory bmfac;
 Staff s;
 
 @BeforeEach
 void setup() throws InvalidStatValueException {
   c= new Controller();
   kfac = new KnightFactory();
   efac = new EnemyFactory();
  k = new Knight("",100,20,c.getQueue());
  e = new Enemy("",100,100,40,40,c.getQueue());
 wmfac = new WhiteMageFactory();
 bmfac= new BlackMageFactory();
 s= new Staff("",30,30,30);
 }
 
 @Test
 void settersAndGetters() throws NullWeaponException, InterruptedException, InvalidWeaponAssignmentException {
  //setFactory
  c.setFactory(kfac);
  //getFactory
  assertEquals(kfac , c.getFactory());
  //getqueue
  Knight knight =kfac.create(c.getQueue());
  Sword sword= new Sword("",30,30);
  knight.equip(sword);
  knight.waitTurn();
  Thread.sleep(4000);
  assertEquals(knight,c.getQueue().get_queue().poll());
  //get characters
  c.getCharacters().add(knight);
  assertEquals(knight,c.getCharacters().get(0));
  // select Magic
  Thunder t = new Thunder();
  c.selectMagic( t);
  assertEquals(t, c.getMagic());
  
 }
 @Test
 void createEnemy() {
  c.setFactory(efac);
  c.createRandomEnemy();
  //avg cases
  assertEquals(c.getEnemies().size(),1);
  assertEquals(c.getEnemies().get(0).getClass() , Enemy.class);
  assertEquals("enemy0",c.getEnemies().get(0).getName());
  c.createRandomEnemy();
  assertEquals(c.getEnemies().size(),2);
  assertEquals(c.getEnemies().get(1).getClass() , Enemy.class);
  assertEquals("enemy1",c.getEnemies().get(1).getName());
  //max
  
 }
 
 @Test
 void attack() throws InvalidWeaponAssignmentException {
 
  Axe a = new Axe("",50,40);
  Enemy e2 = new Enemy("",100,100,60,40,c.getQueue());
  
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
  c.createCharacter();
  assertEquals(true,c.isMaxCharacters());
  c.setMaxCharacters(3);
  assertEquals(false,c.isMaxCharacters());
 }
 
 @Test
 void useMagic() throws NotImplementsMagicException, NotEnughMpException, InvalidWeaponAssignmentException {
  WhiteMage wm= wmfac.create(c.getQueue());
  BlackMage bm= bmfac.create(c.getQueue());
  //Whitemagic
  c.selectMagic(new Poison());
  c.useMagic(wm,e);
  assertEquals(true,e.isAnyEffect(Poisoned.uniqueInstance()));
  assertThrows(NotImplementsMagicException.class,()->c.useMagic(bm,e));
 
  //BlackMagic
  int hp = e.getCurrentHp();
  bm.equip(s);
  Thunder t =new Thunder();
  t.setSeed(10);
  c.selectMagic(t);
  assertThrows(NotImplementsMagicException.class,()->c.useMagic(wm,e));
  c.useMagic(bm,e);
  assertEquals(true,e.isAnyEffect(Paralysis.uniqueInstance()));
  assertEquals(hp-s.getMagicDamage(),e.getCurrentHp());
 }
 
 
}