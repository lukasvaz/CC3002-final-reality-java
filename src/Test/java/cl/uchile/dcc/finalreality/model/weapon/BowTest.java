package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.Test;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.BOW;
import static org.junit.jupiter.api.Assertions.*;

class BowTest {
 Bow bow=new Bow("bow1",30,30);
 Bow bow2=new Bow("bow1",30,30);
 Bow bow3=new Bow("",1,1);
 Staff staff=new Staff("staff",30,30);
 
 
 @Test
 void getName() {
  assertEquals("bow1",bow.getName());
  assertEquals("",bow3.getName());
  
 }
 
 @Test
 void getDamage() {
  assertEquals(30,bow.getDamage());
  assertEquals(1,bow3.getDamage());
 }
 
 @Test
 void getWeight() {
  assertEquals(30,bow.getWeight());
  assertEquals(1,bow3.getWeight());
 
 }
 
 @Test
 void getType() {
  assertEquals(BOW,bow.getType());
  assertEquals(BOW,bow3.getType());
 }
 
 @Test
 void testEquals() {
  assertTrue(bow.equals(bow));
  assertTrue(bow.equals(bow2));
  assertFalse(bow.equals(bow3));
  assertFalse(bow.equals(staff));
 }
 
 @Test
 void testHashCode() {
  assertEquals(bow.hashCode(),bow.hashCode());
  assertEquals(bow.hashCode(),bow2.hashCode());
 
 }
 
 @Test
 void testToString() {
  assertEquals(  "Bow{name='bow1', damage=30, weight=30, type=BOW}",bow.toString());
  assertEquals(  "Bow{name='', damage=1, weight=1, type=BOW}",bow3.toString());
 
 }
}