package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.Test;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.KNIFE;
import static org.junit.jupiter.api.Assertions.*;

class KnifeTest {
 Knife knife=new Knife("knife1",30,30);
 Knife knife2=new Knife("knife1",30,30);
 Knife knife3=new Knife("",1,1);
 Staff staff=new Staff("staff",30,30);
 
 
 @Test
 void getName() {
  assertEquals("knife1",knife.getName());
  assertEquals("",knife3.getName());
 }
 
 @Test
 void getDamage() {
  assertEquals(30,knife.getDamage());
  assertEquals(1,knife3.getDamage());
 }
 
 @Test
 void getWeight() {
  assertEquals(30,knife.getDamage());
  assertEquals(1,knife3.getDamage());
 }
 
 @Test
 void getType() {
  assertEquals(KNIFE,knife.getType());
  assertEquals(KNIFE,knife3.getType());
  
 }
 
 @Test
 void testEquals() {
  assertTrue(knife.equals(knife));
  assertTrue(knife.equals(knife2));
  assertFalse(knife.equals(knife3));
  assertFalse(knife.equals(staff));
 
 
 }
 
 @Test
 void testHashCode() {
  assertEquals(knife.hashCode(),knife.hashCode());
  assertEquals(knife.hashCode(),knife2.hashCode());
  
 }
 
 @Test
 void testToString() {
  assertEquals(  "Knife{name='knife1', damage=30, weight=30, type=KNIFE}",knife.toString());
  assertEquals(  "Knife{name='', damage=1, weight=1, type=KNIFE}",knife3.toString());
 
 }
}