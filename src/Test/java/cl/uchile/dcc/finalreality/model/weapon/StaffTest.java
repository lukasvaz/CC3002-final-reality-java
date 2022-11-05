package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.Test;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.STAFF;
import static org.junit.jupiter.api.Assertions.*;

class StaffTest {
 Staff staff=new Staff("staff1",30,30);
 Staff staff2=new Staff("staff1",30,30);
 Staff staff3=new Staff("",1,1);
 Axe axe=new Axe("",1,1);
 
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