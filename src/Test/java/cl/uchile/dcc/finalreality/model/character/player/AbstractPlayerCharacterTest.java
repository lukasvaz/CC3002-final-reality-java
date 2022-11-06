package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractPlayerCharacterTest {
 TurnsQueue queue;
 Knight knight;
 Engineer engineer;
 Thief thief;
 BlackMage bmage;
 WhiteMage wmage;
 Sword sword;
 Axe axe;
 Knife knife;
 Staff staff;
 Bow bow;
 

 @BeforeEach
 void setup() throws InvalidStatValueException {
  queue= new TurnsQueue();
  
  knight = new Knight("knight1", 10, 10, queue);
  thief = new Thief("thief", 20, 100,queue);
  engineer = new Engineer("eng", 30, 100,queue);
  wmage=new WhiteMage("wmage",100,100,100,queue);
  bmage=new BlackMage("bmage",100,100,100,queue);
  
  sword= new Sword("sword1",30,10);
  axe = new Axe("axe1",30,30);
  knife= new Knife("knife1", 30,20);
  staff= new Staff("staf",30,30);
  bow=new Bow("bow",30,30);
 }
  @Test
 void equipAndGet(){
  assertDoesNotThrow(()->knight.equip(sword));
  assertEquals(sword,knight.getEquippedWeapon());
  assertDoesNotThrow(()->knight.equip(axe));
  assertEquals(axe,knight.getEquippedWeapon());
  assertDoesNotThrow(()->knight.equip(knife));
  assertEquals(knife,knight.getEquippedWeapon());
  assertThrows(InvalidWeaponAssignmentException.class,()->knight.equip(staff));
  assertThrows(InvalidWeaponAssignmentException.class,()->knight.equip(bow));
 
  assertThrows(InvalidWeaponAssignmentException.class,()->engineer.equip(sword));
  assertDoesNotThrow(()->engineer.equip(axe));
  assertEquals(axe,engineer.getEquippedWeapon());
  assertThrows(InvalidWeaponAssignmentException.class,()->engineer.equip(knife));
  assertThrows(InvalidWeaponAssignmentException.class,()->engineer.equip(staff));
  assertDoesNotThrow(()->engineer.equip(bow));
  assertEquals(bow,engineer.getEquippedWeapon());
 
  assertDoesNotThrow(()->thief.equip(sword));
  assertEquals(sword,thief.getEquippedWeapon());
  assertThrows(InvalidWeaponAssignmentException.class,()->thief.equip(axe));
  assertDoesNotThrow(()->thief.equip(knife));
  assertEquals(knife,thief.getEquippedWeapon());
  assertThrows(InvalidWeaponAssignmentException.class,()->thief.equip(staff));
  assertDoesNotThrow(()->thief.equip(bow));
  assertEquals(bow,thief.getEquippedWeapon());
  
   assertThrows(InvalidWeaponAssignmentException.class,()->bmage.equip(sword));
  assertThrows(InvalidWeaponAssignmentException.class,()->bmage.equip(axe));
  assertDoesNotThrow(()->bmage.equip(knife));
  assertEquals(knife,bmage.getEquippedWeapon());
  assertDoesNotThrow(()->bmage.equip(staff));
  assertEquals(staff,bmage.getEquippedWeapon());
  assertThrows(InvalidWeaponAssignmentException.class,()->bmage.equip(bow));
 
  assertThrows(InvalidWeaponAssignmentException.class,()->wmage.equip(sword));
  assertThrows(InvalidWeaponAssignmentException.class,()->wmage.equip(axe));
  assertThrows(InvalidWeaponAssignmentException.class,()->wmage.equip(knife));
  assertDoesNotThrow(()->wmage.equip(staff));
  assertEquals(staff,wmage.getEquippedWeapon());
  assertThrows(InvalidWeaponAssignmentException.class,()->wmage.equip(bow));
  
 }

 @Test
 void waitTurn() throws InterruptedException, InvalidWeaponAssignmentException {

  knight.equip(sword);
  thief.equip(knife);
  engineer.equip(axe);
  
  engineer.waitTurn();
  thief.waitTurn();
  knight.waitTurn();
  Thread.sleep(12000);
  assertEquals(knight,queue.get_queue().poll());
  assertEquals(thief,queue.get_queue().poll());
  assertEquals(engineer,queue.get_queue().poll());
 
 }
 @Test
 void testinvalidexception() {
  assertThrows(InvalidStatValueException.class, ()-> {new BlackMage("name",20,20,-100,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new Knight("name",20,-1,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new Engineer("name",0,100,queue);});
 }
}