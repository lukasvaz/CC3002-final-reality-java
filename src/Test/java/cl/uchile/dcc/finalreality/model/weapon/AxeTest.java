package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.AXE;
import static org.junit.jupiter.api.Assertions.*;

class AxeTest {
 
 Axe axe=new Axe("axe1",30,30);
 Axe axe2=new Axe("axe1",30,30);
 Axe axe3=new Axe("",1,1);
 Staff staff=new Staff("staff",30,30);
 @Test
 void getName() {
  assertEquals("axe1",axe.getName());
  assertEquals("",axe3.getName());
 }
 
 @Test
 void getDamage() {
  assertEquals(30,axe.getDamage());
  assertEquals(1,axe3.getDamage());
 }
 
 @Test
 void getWeight() {
  assertEquals(30,axe.getWeight());
  assertEquals(1,axe3.getWeight());
  
 }
 
 @Test
 void getType() {
  assertEquals(AXE,axe.getType());
  assertEquals(AXE,axe3.getType());
 
 }
 
 @Test
 void testEquals() {
  assertTrue(axe.equals(axe));
  assertTrue(axe.equals(axe2));
  assertFalse(axe.equals(axe3));
  assertFalse(axe.equals(staff));
 
 
 }
 
 @Test
 void testHashCode() {
  assertEquals(axe.hashCode(),axe.hashCode());
  assertEquals(axe.hashCode(),axe2.hashCode());
 
 }
 
 @Test
 void testToString() {
  assertEquals(  "Axe{name='axe1', damage=30, weight=30, type=AXE}",axe.toString());
  assertEquals(  "Axe{name='', damage=1, weight=1, type=AXE}",axe3.toString());
  
 }
 
}