package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.STAFF;
import static org.junit.jupiter.api.Assertions.*;

class StaffTest {
 Staff staff;
 Staff staff2;
 Staff staff3;
 Axe axe;
 Knight knight;
 Engineer engineer;
 Thief thief;
 BlackMage bmage;
 WhiteMage wmage;
 TurnsQueue queue;
 @BeforeEach
 void setup() throws InvalidStatValueException {
  staff=new Staff("staff1",30,30);
  staff2=new Staff("staff1",30,30);
  staff3=new Staff("",1,1);
  axe=new Axe("",1,1);
  queue=new TurnsQueue();
  knight= new Knight("name",10,10,queue);
  engineer=new Engineer("name",10,10,queue);
  thief=new Thief("name",10,10,queue);
  bmage=new BlackMage("name",10,10,10,queue);
  wmage=new WhiteMage("name",10,10,10,queue);
 }
 
 @Test
 void equippedby(){
  assertThrows(InvalidWeaponAssignmentException.class,()->staff.equippedby(knight));
  assertThrows(InvalidWeaponAssignmentException.class,()->staff.equippedby(engineer));
  assertThrows(InvalidWeaponAssignmentException.class,()->staff.equippedby(thief));
  assertDoesNotThrow(()->staff.equippedby(bmage));
  assertDoesNotThrow(()->staff.equippedby(wmage));
 }
 @Test
 void getName() {
  assertEquals("staff1",staff.getName());
  assertEquals("",staff3.getName());
 }
 
 @Test
 void getDamage() {
  assertEquals(30,staff.getDamage());
  assertEquals(1,staff3.getDamage());
 }
 
 @Test
 void getWeight() {
  assertEquals(30,staff.getWeight());
  assertEquals(1,staff3.getWeight());
 }
 
 @Test
 void getType() {
  assertEquals(STAFF,staff.getType());
  assertEquals(STAFF,staff3.getType());
 }
 
 @Test
 void testEquals() {
  assertTrue(staff.equals(staff));
  assertTrue(staff.equals(staff2));
  assertFalse(staff.equals(staff3));
  assertFalse(staff.equals(axe));
 }
 
 @Test
 void testHashCode() {
  assertEquals(staff.hashCode(),staff.hashCode());
  assertEquals(staff.hashCode(),staff2.hashCode());
 }
 
 @Test
 void testToString() {
  assertEquals(  "Staff{name='staff1', damage=30, weight=30, type=STAFF}",staff.toString());
  assertEquals(  "Staff{name='', damage=1, weight=1, type=STAFF}",staff3.toString());
 }
}