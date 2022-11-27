package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.factories.BlackMageFactory;
import cl.uchile.dcc.finalreality.model.factories.IFactory;
import cl.uchile.dcc.finalreality.model.factories.KnightFactory;
import cl.uchile.dcc.finalreality.model.factories.WhiteMageFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
 Controller c;
 IFactory k;
 IFactory wm;
 IFactory bm;
 TurnsQueue q;
 @BeforeEach
 void setup() throws InvalidStatValueException {
   c= new Controller();
   k = new KnightFactory().uniqueInstance();
   wm = new WhiteMageFactory();
   bm = new BlackMageFactory();
   
   
 }
 
 @Test
 void selectCharacter() {
  c.selectCharacter("Knight");
  assertEquals(c.getFactory().getClass(),KnightFactory.class);
  c.selectCharacter("BlackMage");
  assertEquals(c.getFactory().getClass(), BlackMageFactory.class);
  c.selectCharacter("WhiteMage");
  assertEquals(c.getFactory().getClass(), WhiteMageFactory.class );
 }
 @Test
 void createCharacter() {
  c.selectCharacter("Knight");
  c.createCharacter(q);
  assertEquals(c.getCharacters().size(),1);
  assertEquals(c.getCharacters().get(0).getClass() , Knight.class);
  c.selectCharacter("WhiteMage");
  c.createCharacter(q);
  assertEquals(c.getCharacters().size(),2);
  assertEquals(c.getCharacters().get(1).getClass() , WhiteMage.class);
 }
 @Test
 void createEnemy() {
  c.selectCharacter("Enemy");
  c.createEnemy(q);
  assertEquals(c.getEnemies().size(),1);
  assertEquals(c.getEnemies().get(0).getClass() , Enemy.class);
  c.createEnemy(q);
  assertEquals(c.getEnemies().size(),2);
  assertEquals(c.getEnemies().get(1).getClass() , Enemy.class);
 }
}