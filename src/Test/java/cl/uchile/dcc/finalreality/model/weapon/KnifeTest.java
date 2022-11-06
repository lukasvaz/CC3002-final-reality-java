package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.KNIFE;
import static org.junit.jupiter.api.Assertions.*;

class KnifeTest {
 Knife knife;
 Knife knife2;
 Knife knife3 ;
 Staff staff;
 Knight knight;
 Engineer engineer;
 Thief thief;
 BlackMage bmage;
 WhiteMage wmage;
 TurnsQueue queue;
 @BeforeEach
 void setup() throws InvalidStatValueException {
  knife=new Knife("knife1",30,30);
  knife2=new Knife("knife1",30,30);
  knife3=new Knife("",1,1);
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
  assertDoesNotThrow(()->knife.equippedby(knight));
  assertThrows(InvalidWeaponAssignmentException.class,()->knife.equippedby(engineer));
  assertDoesNotThrow(()->knife.equippedby(thief));
  assertDoesNotThrow(()->knife.equippedby(bmage));
  assertThrows(InvalidWeaponAssignmentException.class,()->knife.equippedby(wmage));
 }
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