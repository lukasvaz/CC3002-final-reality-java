package cl.uchile.dcc.finalreality.controller;

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
 @BeforeEach
 void setup() throws InvalidStatValueException {
   c= new Controller();
   
 }
 
 @Test
 void selectCharacter() {
  c.selectCharacterCreation("Knight");
  assertEquals(c.getFactory().getClass(),KnightFactory.class);
  c.selectCharacterCreation("BlackMage");
  assertEquals(c.getFactory().getClass(), BlackMageFactory.class);
  c.selectCharacterCreation("WhiteMage");
  assertEquals(c.getFactory().getClass(), WhiteMageFactory.class );
 }
 @Test
 void createCharacter() {
  c.selectCharacterCreation("Knight");
  c.createCharacter(q);
  assertEquals(c.getCharacters().size(),1);
  assertEquals(c.getCharacters().get(0).getClass() , Knight.class);
  c.selectCharacterCreation("WhiteMage");
  c.createCharacter(q);
  assertEquals(c.getCharacters().size(),2);
  assertEquals(c.getCharacters().get(1).getClass() , WhiteMage.class);
 }
 @Test
 void createEnemy() {
  c.selectCharacterCreation("Enemy");
  c.createEnemy(q);
  assertEquals(c.getEnemies().size(),1);
  assertEquals(c.getEnemies().get(0).getClass() , Enemy.class);
  c.createEnemy(q);
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
  c.selectCharacterCreation("Knight");
  c.createCharacter(q);
  assertEquals(true,c.isMaxCharacters());
  c.setMaxCharacters(3);
  assertEquals(false,c.isMaxCharacters());
 }
 
}