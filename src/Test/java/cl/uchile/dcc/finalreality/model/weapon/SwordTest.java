package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.SWORD;
import static org.junit.jupiter.api.Assertions.*;

class SwordTest {
 Sword sword;
 Sword sword2;
 Sword sword3 ;
 Staff staff;
 Knight knight;
 Engineer engineer;
 Thief thief;
 BlackMage bmage;
 WhiteMage wmage;
 TurnsQueue queue;
 
 @BeforeEach
 void setup() throws InvalidStatValueException {
  sword=new Sword("sword1",30,30);
  sword2=new Sword("sword1",30,30);
  sword3=new Sword("",1,1);
  staff=new Staff("staff",30,30);
  queue=new TurnsQueue();
  knight= new Knight("name",10,10,queue);
  engineer=new Engineer("name",10,10,queue);
  thief=new Thief("name",10,10,queue);
  bmage=new BlackMage("name",10,10,10,queue);
  wmage=new WhiteMage("name",10,10,10,queue);
 }
 
 @Test
 void getName() {
  assertEquals("sword1",sword.getName());
  assertEquals("",sword3.getName());
 }
 @Test
 void equippedby(){
  assertDoesNotThrow(()->sword.equippedby(knight));
  assertThrows(InvalidWeaponAssignmentException.class,()->sword.equippedby(engineer));
  assertDoesNotThrow(()->sword.equippedby(thief));
  assertThrows(InvalidWeaponAssignmentException.class,()->sword.equippedby(bmage));
  assertThrows(InvalidWeaponAssignmentException.class,()->sword.equippedby(wmage));
 }
 
 @Test
 void getDamage() {
  assertEquals(30,sword.getDamage());
  assertEquals(1,sword3.getDamage());
 }
 
 @Test
 void getWeight() {
  assertEquals(30,sword.getDamage());
  assertEquals(1,sword3.getDamage());
 }
 
 @Test
 void getType() {
  assertEquals(SWORD,sword.getType());
  assertEquals(SWORD,sword3.getType());
 }
 
 @Test
 void testEquals() {
  assertTrue(sword.equals(sword));
  assertTrue(sword.equals(sword2));
  assertFalse(sword.equals(sword3));
  assertFalse(sword.equals(staff));
 
 }
 
 @Test
 void testHashCode() {
  assertEquals(sword.hashCode(),sword.hashCode());
  assertEquals(sword.hashCode(),sword2.hashCode());
 }
 
 @Test
 void testToString() {
  assertEquals(  "Sword{name='sword1', damage=30, weight=30, type=SWORD}",sword.toString());
  assertEquals(  "Sword{name='', damage=1, weight=1, type=SWORD}",sword3.toString());
  
 }
}