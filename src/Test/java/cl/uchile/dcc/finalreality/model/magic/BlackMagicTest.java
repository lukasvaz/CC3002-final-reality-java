package cl.uchile.dcc.finalreality.model.magic;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackMagicTest {
 
 TurnsQueue q;
 BlackMage bm;
 Enemy e;
 Enemy e2;
 Fire f;
 Staff s;
 
 @BeforeEach
 void setup() {
  q = new TurnsQueue();
  s= new Staff("",30,30,10);
  bm = new BlackMage("",20,50,30,q);
  e = new Enemy("",30,100,30,20,q);
  f = new Fire();
  
 }
 
 @Test
 void isImplentedBy() {
  TurnsQueue q = new TurnsQueue();
  BlackMage bm = new BlackMage("",2,3,2,q);
  WhiteMage wm = new WhiteMage("",2,3,2,q);
  Thunder h = new Thunder();
  
  assertEquals(false , h.isImplentedBy(wm));
  assertEquals(true , h.isImplentedBy(bm));
  
 }
 
 @Test
 void CharacterOnTest()  {
  assertThrows(NotImplementsMagicException.class ,()-> f.nonMagicCharacterOn(e,e));
  assertThrows(NotImplementsMagicException.class ,()-> f.whiteMageOn(e,e));
  assertThrows(NotImplementsMagicException.class ,()-> f.enemyOn(e,e));
 }
 
 @Test
 void blackMageOnTest() throws InvalidWeaponAssignmentException {
  bm.equip(s);
  assertDoesNotThrow(()-> f.blackMageOn(bm,e));
 assertEquals(90,e.getCurrentHp());
 assertEquals(15,bm.getcurrentMp());
 }
}