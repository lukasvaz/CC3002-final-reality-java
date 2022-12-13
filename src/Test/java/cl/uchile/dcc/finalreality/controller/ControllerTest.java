package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.controller.factories.EnemyFactory;
import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
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
import cl.uchile.dcc.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
 void setandget() throws NullWeaponException, InterruptedException, InvalidWeaponAssignmentException {
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
  assertEquals(c,c.getEnemies().get(1).getController());
  //max
 }
 
 @Test
 void createCharacter() {
  c.setFactory(kfac);
  c.createCharacter();
  //avg cases
  assertEquals(c.getCharacters().size(),1);
  assertEquals(c.getCharacters().get(0).getClass() , Knight.class);
  assertEquals(c.getCharacters().get(0).getController() ,c);

  //max
 }
 
 
 @Test
 void attack() throws InvalidWeaponAssignmentException, NullWeaponException {
 
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
 void setAndIsMaxCharacter() throws NullWeaponException {
  c.setMaxCharacters(1);
  c.setFactory( new KnightFactory());
  c.createCharacter();
  assertEquals(true,c.isMaxCharacters());
  c.setMaxCharacters(3);
  assertEquals(false,c.isMaxCharacters());
 }
 
 @Test
 void uniqueInstance() {
  e.setController(Controller.getUniqueInstance());
  k=kfac.create(Controller.getUniqueInstance().getQueue());
  k.setController(Controller.getUniqueInstance());
 assertEquals(e.getController(),k.getController());
 assertEquals(e.getController(),Controller.getUniqueInstance());
 assertEquals(k.getController(),Controller.getUniqueInstance());
 }
 
 @Test
 void useMagic() throws NotImplementsMagicException, NotEnughMpException, InvalidWeaponAssignmentException, NullWeaponException {

  WhiteMage wm= wmfac.create(c.getQueue());
  BlackMage bm= bmfac.create(c.getQueue());
  //Whitemagic
  c.selectMagic(new Poison());
  wm.equip(s);
  c.useMagic(wm,e);
  System.out.println(e.getEffects());
  assertEquals(true,e.isAnyEffect(new Poisoned()));
  assertThrows(NotImplementsMagicException.class,()->c.useMagic(bm,e));
  
  //BlackMagic
  int hp = e.getCurrentHp();
  bm.equip(s);
  Thunder t =new Thunder();
  t.setSeed(10);
  c.selectMagic(t);
  assertThrows(NotImplementsMagicException.class,()->c.useMagic(wm,e));
  c.useMagic(bm,e);
  assertEquals(1,e.getEffects().size());
  assertEquals(true, e.isAnyEffect(new Poisoned()));
  assertEquals(hp-s.getMagicDamage(),e.getCurrentHp());
 }
 
 @Test
 void updateDeaths(){
  Knight k = kfac.create(c.getQueue());
  e.setController(c);
  k.setController(c);
  c.getEnemies().add(e);
  c.getCharacters().add(k);
  c.getQueue().get_queue().add(k);
  c.getQueue().get_queue().add(e);
  assertEquals(new ArrayList<>(Arrays.asList(k)),c.getCharacters());
  assertEquals(new ArrayList<>(Arrays.asList(e)),c.getEnemies());
  
  //setting Hp to zero
  e.setCurrentHp(0);
  k.setCurrentHp(0);
  //should be extaracted from queue and enenmylist
  c.updateDeaths(e);
  assertEquals(false , c.getQueue().get_queue().contains(e));
  assertEquals(true, c.getQueue().get_queue().contains(k));
  assertEquals(true,c.getEnemies().isEmpty());
 
  //should be extaracted from queue and characterlist
  c.updateDeaths(k);
  assertEquals(true,c.getCharacters().isEmpty());
  assertEquals(false , c.getQueue().get_queue().contains(k));

 }
 
 @Test
 void equipfromInventary() throws InvalidWeaponAssignmentException, WeaponNotInInventoryException, NullWeaponException {
  BlackMage w = new BlackMage("",100,100,100,c.getQueue());
  Staff s=new Staff("",30,30,30);
  Knife k=new Knife("",30,30);
  c.setInventary(new ArrayList<>(Arrays.asList( s)));
  assertThrows(WeaponNotInInventoryException.class ,()->c.equipFromInvetory(w,k));
  assertDoesNotThrow(()->c.equipFromInvetory(w,s));
  assertEquals(s,w.getEquippedWeapon());
 }
 @Test
 void defaultCharacterSelection(){
  c.defaultCharacterSelection();
  assertEquals(5,c.getCharacters().size());
 }
 @Test
 void createnormalInventory(){
  c.defaultInventary();
  assertEquals(5,c.getInventary().size());
 }
 @Test
 void defWeaponAssignment() throws InvalidWeaponAssignmentException, WeaponNotInInventoryException, NullWeaponException {
  c.defaultInventary();
  c.defaultCharacterSelection();
  c.defaultWpnAssignment();
  assertEquals(Axe.class,c.getCharacters().get(0).getEquippedWeapon().getClass());
  assertEquals(Sword.class,c.getCharacters().get(1).getEquippedWeapon().getClass());
  assertEquals(Knife.class,c.getCharacters().get(4).getEquippedWeapon().getClass());
 }
 @Test
 void setRandomCharacterTarget() {
  //1char
  c.getCharacters().clear();
  c.setFactory(new KnightFactory());
  GameCharacter k = c.createCharacter();
  System.out.println(c.getCharacters());
  assertEquals(1,c.getCharacters().size());
  c.setRandomCharacterTarget();
  assertEquals(k,c.getTarget());
  c.setTarget(null);
 
  //empty aray
  c.getCharacters().clear();
  c.setRandomCharacterTarget();
  assertEquals(null,c.getTarget());
  c.getCharacters().clear();
  c.setTarget(null);
 
  c.defaultCharacterSelection();
  c.setSeed(20);
  //3 examples
  c.setRandomCharacterTarget();
  assertEquals(c.getCharacters().get(3),c.getTarget());
  c.setRandomCharacterTarget();
  assertEquals(c.getCharacters().get(1),c.getTarget());
  c.setRandomCharacterTarget();
  assertEquals(c.getCharacters().get(1),c.getTarget());
 }
 @Test
 void countEquippedCharacters() throws InvalidWeaponAssignmentException, WeaponNotInInventoryException {
  //equip 0 char
  c.defaultCharacterSelection();
  assertEquals(0,c.countEquippedCharacter());
  //equip 1 char
  c.getCharacters().get(0).equip(new Bow("",30,30));
  assertEquals(1,c.countEquippedCharacter());
  //equip all 5 char
  c.defaultInventary();
  c.defaultWpnAssignment();
  assertEquals(5,c.countEquippedCharacter());
 }
 
}