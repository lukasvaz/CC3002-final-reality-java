package cl.uchile.dcc.finalreality.model.magic;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMagicTest {
 
 TurnsQueue q;
 WhiteMage wm;
 Enemy e;
 Enemy e2;
 Heal h;
 Staff s;
 Knight k;
 
 @BeforeEach
 void setup() {
  q = new TurnsQueue();
  s= new Staff("",30,30,10);
  wm = new WhiteMage("",20,50,30,q);
  e = new Enemy("",30,100,30,20,q);
  h = new Heal();
  k = new Knight("",100,10,q);
 }
 
 @Test
 void isImplentedBy() {
  TurnsQueue q = new TurnsQueue();
  BlackMage bm = new BlackMage("",2,3,2,q);
  WhiteMage wm = new WhiteMage("",2,3,2,q);
  Heal h = new Heal();
  assertEquals(true , h.isImplentedBy(wm));
  assertEquals(false , h.isImplentedBy(bm));
 }
 
 @Test
 void CharacterOnTest()  {
  assertThrows(NotImplementsMagicException.class ,()-> h.nonMagicCharacterOn(e,e));
  assertThrows(NotImplementsMagicException.class ,()-> h.blackMageOn(e,e));
  assertThrows(NotImplementsMagicException.class ,()-> h.enemyOn(e,e));
 }
 
 @Test
 void WhiteMageOnTest() throws InvalidWeaponAssignmentException {
  wm.equip(s);
  k.setCurrentHp(10);
  wm.setCurrentMp(30);
  assertDoesNotThrow(()-> h.whiteMageOn(wm,k));
  assertEquals(40,k.getCurrentHp());
  assertEquals(15,wm.getcurrentMp());
 }
}