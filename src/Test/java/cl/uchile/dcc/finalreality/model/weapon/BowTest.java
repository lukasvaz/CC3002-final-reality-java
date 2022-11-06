package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.BOW;
import static org.junit.jupiter.api.Assertions.*;

class BowTest {
 Bow bow;
 Bow bow2;
 Bow bow3;
 Staff staff;
 Knight knight;
 Engineer engineer;
 Thief thief;
 BlackMage bmage;
 WhiteMage wmage;
 TurnsQueue queue;
 
 @BeforeEach
 void setup() throws InvalidStatValueException {
  bow=new Bow("bow1",30,30);
  bow2=new Bow("bow1",30,30);
  bow3=new Bow("",1,1);
  staff=new Staff("staff",30,30);
  queue=new TurnsQueue();
  knight= new Knight("name",10,10,queue);
  engineer=new Engineer("name",10,10,queue);
  thief=new Thief("name",10,10,queue);
  bmage=new BlackMage("name",10,10,10,queue);
  wmage=new WhiteMage("name",10,10,10,queue);
 }
 
 @Test
 void equippedby(){
  assertThrows(InvalidWeaponAssignmentException.class,()->bow.equippedby(knight));
  assertDoesNotThrow(()->bow.equippedby(engineer));
  assertDoesNotThrow(()->bow.equippedby(thief));
  assertThrows(InvalidWeaponAssignmentException.class,()->bow.equippedby(bmage));
  assertThrows(InvalidWeaponAssignmentException.class,()->bow.equippedby(wmage));
 }
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