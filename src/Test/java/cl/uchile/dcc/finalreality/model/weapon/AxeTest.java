package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.AXE;
import static org.junit.jupiter.api.Assertions.*;

class AxeTest {
 
 Axe axe;
 Axe axe2;
 Axe axe3;
 Staff staff;
 Knight knight;
 Engineer engineer;
 Thief thief;
 BlackMage bmage;
 WhiteMage wmage;
 TurnsQueue queue;
 
 @BeforeEach
 void setup() throws InvalidStatValueException {
  axe=new Axe("axe1",30,30);
  axe2=new Axe("axe1",30,30);
  axe3=new Axe("",1,1);
  staff=new Staff("staff",30,30,10);
  queue=new TurnsQueue();
  knight= new Knight("name",10,10,queue);
  engineer=new Engineer("name",10,10,queue);
  thief=new Thief("name",10,10,queue);
  bmage=new BlackMage("name",10,10,10,queue);
  wmage=new WhiteMage("name",10,10,10,queue);
 }
 @Test
 void getName() {
  assertEquals("axe1",axe.getName());
  assertEquals("",axe3.getName());
 }
 @Test
 void equippedby(){
  assertDoesNotThrow(()->axe.equippedby(knight));
  assertDoesNotThrow(()->axe.equippedby(engineer));
  assertThrows(InvalidWeaponAssignmentException.class,()->axe.equippedby(thief));
  assertThrows(InvalidWeaponAssignmentException.class,()->axe.equippedby(bmage));
  assertThrows(InvalidWeaponAssignmentException.class,()->axe.equippedby(wmage));
 }
 @Test
 void getDamageandAttack() {
  assertEquals(30,axe.getDamage());
  assertEquals(1,axe3.getDamage());
  assertEquals(15,axe.magicAttack());
  
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