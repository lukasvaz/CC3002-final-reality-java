package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.Player;
import cl.uchile.dcc.finalreality.controller.factories.EngineerFactory;
import cl.uchile.dcc.finalreality.controller.factories.KnightFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.view.PrimitiveView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTurnTest {
 private final static InputStream systemIn = System.in;
 private final static PrintStream systemOut = System.out;
 private ByteArrayInputStream typeIn;
 private static ByteArrayOutputStream typeOut;
 StateInterface characterTurn;
 Controller c;

 @BeforeEach
 void setUp(){
  c = new Controller();
  characterTurn = new CharacterTurn();
 }

 
 
 @Test
 void action() throws InvalidWeaponAssignmentException, WeaponNotInInventoryException, NullWeaponException, IOException {
  c.setState(characterTurn);
  c.setView(new PrimitiveView());
  c.setFactory(new EngineerFactory());
  c.setSeed(20);
  PlayerCharacter p =c.createCharacter();
  c.setActiveCharacter(p);
  c.defaultInventary();
  Enemy e = c.createRandomEnemy();
  Enemy e2 =  c.createRandomEnemy();

  //scripted player vs 2 enemies
  
  e.setCurrentHp(60);
  e.setDefense(10);
  c.setState(characterTurn);
  c.setPlayer( new Player("1\nok\n0"));//equips bow to an Engineer
  c.getState().action(c);
  assertEquals(Bow.class,p.getEquippedWeapon().getClass());
  assertEquals(30,p.getEquippedWeapon().getDamage());
  assertEquals(40,e.getCurrentHp());
  assertEquals(initTurn.class,c.getState().getClass());
  
  //ScriptedPlayer vs 1 enemy ,enemy dies
  c.getEnemies().remove(e2);
  c.getQueue().get_queue().remove(e2);
  c.setFactory(new KnightFactory());
  PlayerCharacter k = c.createCharacter();
  c.setState(characterTurn);
  c.setActiveCharacter(k);
  e.setCurrentHp(10);
  e.setDefense(10);
  c.setPlayer( new Player("0\nok\n0"));
  c.getState().action(c);
  assertEquals(Axe.class,k.getEquippedWeapon().getClass());
  System.out.println(e.getCurrentHp());
  assertEquals(80,k.getEquippedWeapon().getDamage());
  assertEquals(0,e.getCurrentHp());
  System.out.println(c.getEnemies());
  assertEquals(true,c.getEnemies().isEmpty());
  assertEquals(End.class,c.getState().getClass());
 }
 
}