package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
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
  axe = new Axe("axe1",30,20);
  knife= new Knife("knife1", 30,30);
  staff= new Staff("staf",30,40,10);
  bow=new Bow("bow",30,50);
 }
 
 @Test
 void getAttack() throws InvalidWeaponAssignmentException, NullWeaponException {
  knight.equip(sword);
  assertEquals(knight.getAttack(),sword.getDamage());
  wmage.equip(staff);
  assertEquals(wmage.getAttack(),staff.getDamage());
  thief.equip(knife);
  assertEquals(thief.getAttack(),knife.getDamage());
 }
 @Test
 void getMagicAttack() throws InvalidWeaponAssignmentException, NullWeaponException {
  knight.equip(sword);
  assertEquals(knight.getMagicAttack(),sword.getDamage());
  wmage.equip(staff);
  assertEquals(wmage.getMagicAttack(),staff.getMagicDamage());
  thief.equip(knife);
  assertEquals(thief.getAttack(),knife.getDamage());
 }
  @Test
 void RestrictionsWeapontests(){
  assertDoesNotThrow(()->knight.equip(sword));
  assertDoesNotThrow(()->knight.equip(axe));
  assertDoesNotThrow(()->knight.equip(knife));
  assertThrows(InvalidWeaponAssignmentException.class,()->knight.equip(staff));
  assertThrows(InvalidWeaponAssignmentException.class,()->knight.equip(bow));
 
  assertThrows(InvalidWeaponAssignmentException.class,()->engineer.equip(sword));
  assertDoesNotThrow(()->engineer.equip(axe));
  assertThrows(InvalidWeaponAssignmentException.class,()->engineer.equip(knife));
  assertThrows(InvalidWeaponAssignmentException.class,()->engineer.equip(staff));
  assertDoesNotThrow(()->engineer.equip(bow));
 
 
  assertDoesNotThrow(()->thief.equip(sword));
  assertThrows(InvalidWeaponAssignmentException.class,()->thief.equip(axe));
  assertDoesNotThrow(()->thief.equip(knife));
  assertThrows(InvalidWeaponAssignmentException.class,()->thief.equip(staff));
  assertDoesNotThrow(()->thief.equip(bow));
  
  assertThrows(InvalidWeaponAssignmentException.class,()->bmage.equip(sword));
  assertThrows(InvalidWeaponAssignmentException.class,()->bmage.equip(axe));
  assertDoesNotThrow(()->bmage.equip(knife));
  assertDoesNotThrow(()->bmage.equip(staff));
  assertThrows(InvalidWeaponAssignmentException.class,()->bmage.equip(bow));
 
  assertThrows(InvalidWeaponAssignmentException.class,()->wmage.equip(sword));
  assertThrows(InvalidWeaponAssignmentException.class,()->wmage.equip(axe));
  assertThrows(InvalidWeaponAssignmentException.class,()->wmage.equip(knife));
  assertDoesNotThrow(()->wmage.equip(staff));
  assertThrows(InvalidWeaponAssignmentException.class,()->wmage.equip(bow));
  
 }
 @Test
 void equipAndGetWeapontests() throws InvalidWeaponAssignmentException, NullWeaponException {
  knight.equip(sword);
  assertEquals(sword,knight.getEquippedWeapon());
  knight.equip(axe);
  assertEquals(axe,knight.getEquippedWeapon());
  knight.equip(knife);
  assertEquals(knife,knight.getEquippedWeapon());
  engineer.equip(axe);
  assertEquals(axe,engineer.getEquippedWeapon());
  engineer.equip(bow);
  assertEquals(bow,engineer.getEquippedWeapon());
  thief.equip(sword);
  assertEquals(sword,thief.getEquippedWeapon());
  thief.equip(knife);
  assertEquals(knife,thief.getEquippedWeapon());;
  thief.equip(bow);
  assertEquals(bow,thief.getEquippedWeapon());
  bmage.equip(knife);
  assertEquals(knife,bmage.getEquippedWeapon());
  bmage.equip(staff);
  assertEquals(staff,bmage.getEquippedWeapon());
  wmage.equip(staff);
  assertEquals(staff,wmage.getEquippedWeapon());
 }

 @Test
 void waitTurn() throws InterruptedException, InvalidWeaponAssignmentException, NullWeaponException {
 
  //correct order//
  knight.equip(sword);
  engineer.equip(axe);
  bmage.equip(knife);
  wmage.equip(staff);
  thief.equip(bow);

  //unordered waitTurn()//
  bmage.waitTurn();
  knight.waitTurn();
  wmage.waitTurn();
  engineer.waitTurn();
  thief.waitTurn();
  Thread.sleep(8000);
  
  assertEquals(knight,queue.get_queue().poll());
  assertEquals(engineer,queue.get_queue().poll());
  assertEquals(bmage,queue.get_queue().poll());
  assertEquals(wmage,queue.get_queue().poll());
  assertEquals(thief,queue.get_queue().poll());
  
 }
 @Test
 void NullweaponExceptiontest(){
  assertThrows(NullWeaponException.class,()->wmage.waitTurn());
  assertThrows(NullWeaponException.class,()->bmage.waitTurn());
  assertThrows(NullWeaponException.class,()->engineer.waitTurn());
  assertThrows(NullWeaponException.class,()->knight.waitTurn());
  assertThrows(NullWeaponException.class,()->thief.waitTurn());
  
 }
 @Test
 void testinvaliStatdexception() {
  assertThrows(InvalidStatValueException.class, ()-> {new BlackMage("name",20,20,-100,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new Knight("name",20,-1,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new Engineer("name",0,100,queue);});
 }
}