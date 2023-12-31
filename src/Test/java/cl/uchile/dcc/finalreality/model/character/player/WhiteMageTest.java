package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.magic.Heal;
import cl.uchile.dcc.finalreality.model.magic.Thunder;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMageTest {
 TurnsQueue queue;
 WhiteMage wmage1;
 WhiteMage wmage2;
 WhiteMage wmage_name;
 WhiteMage wmage_defense;
 WhiteMage wmage_maxHp;
 WhiteMage wmage_maxmp;
 Enemy enemy;
 
 @BeforeEach
 void setup() throws InvalidStatValueException {
  queue= new TurnsQueue();
  wmage1= new WhiteMage("wmage1",40,40,100,queue);
  wmage2= new WhiteMage("wmage1",40,40,100,queue);
  wmage_name= new WhiteMage("wmage3",40,40,100,queue);
  wmage_defense= new WhiteMage("wmage1",44,40,100,queue);
  wmage_maxHp= new WhiteMage("wmage1",40,44,100,queue);
  wmage_maxmp= new WhiteMage("wmage1",40,40,80,queue);
  enemy=new Enemy("enemy",40,40,40,10,queue);
  
 }
 
 @Test
 void testEquals() throws InvalidStatValueException {
  assertTrue(wmage1.equals(wmage1));
  assertTrue(wmage1.equals(wmage2));
  assertFalse(wmage1.equals(wmage_name));
  assertFalse(wmage1.equals(wmage_maxHp));
  assertFalse(wmage1.equals(wmage_maxmp));
  assertFalse(wmage1.equals(wmage_defense));
  assertFalse(wmage1.equals(enemy));
 }
 
 @Test
 void testHashCode() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  WhiteMage wmage1= new WhiteMage("wmage1",40,40,100,queue);
  WhiteMage wmage2= new WhiteMage("wmage1",40,40,100,queue);
  assertEquals(wmage1.hashCode(),wmage1.hashCode());
  assertEquals(wmage1.hashCode(),wmage2.hashCode());
  
 }
 
 @Test
 void testToString() throws InvalidStatValueException {
  TurnsQueue queue = new TurnsQueue();
  WhiteMage wmage = new WhiteMage("wmage1",40,40,100,queue);
  assertEquals("WhiteMage{currentMp=100, maxMp=100, maxHp=40, defense=40, name='wmage1'}",wmage.toString());
 }
 @Test
 void testinvalidexception()  {
  assertThrows(InvalidStatValueException.class, ()-> {new WhiteMage("name",20,20,-100,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new WhiteMage("name",20,-1,100,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new WhiteMage("name",0,100,100,queue);});
 }
 
 @Test
 void testImplementsWhiteAndBlackMagic() {
  assertEquals( true,wmage1.implementsWhiteMagic());
  assertEquals( false,wmage1.implementsBlackMagic());
 }
 
 @Test
 void testImplementsMagic() throws InvalidWeaponAssignmentException {
  Staff s=new Staff("",20,20,30);
  wmage1.equip(s);
  Thunder t = new Thunder();
  Heal h = new Heal();
  System.out.println(enemy);
  assertThrows(NotImplementsMagicException.class, ()-> wmage1.implementsMagic (t,enemy));
  enemy.setCurrentHp(10);
  assertDoesNotThrow( ()-> wmage1.implementsMagic (h,enemy));
  assertEquals(10+40*3/10, enemy.getCurrentHp());
  assertEquals(85, wmage1.getcurrentMp());
 }
 
}