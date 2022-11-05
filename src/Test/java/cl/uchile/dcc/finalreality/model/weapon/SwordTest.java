package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.Test;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.SWORD;
import static org.junit.jupiter.api.Assertions.*;

class SwordTest {
 Sword sword=new Sword("sword1",30,30);
 Sword sword2=new Sword("sword1",30,30);
 Sword sword3=new Sword("",1,1);
 Staff staff=new Staff("staff",30,30);
 
 
 @Test
 void getName() {
  assertEquals("sword1",sword.getName());
  assertEquals("",sword3.getName());
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