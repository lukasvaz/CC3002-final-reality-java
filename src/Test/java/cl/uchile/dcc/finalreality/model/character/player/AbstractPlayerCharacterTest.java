package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractPlayerCharacterTest {
 TurnsQueue queue;
 Knight knight;
 Axe axe;
 Thief thief;
 Engineer engineer;
 Sword sword;
 Knife knife;

 @BeforeEach
 void setup() throws InvalidStatValueException {
  queue= new TurnsQueue();
  
  knight = new Knight("knight1", 10, 10, queue);
  thief = new Thief("thief", 20, 100,queue);
  engineer = new Engineer("eng", 30, 100,queue);
  
  axe = new Axe("axe1",30,30);
  sword= new Sword("sword1",30,10);
  knife= new Knife("knife1", 30,20);
 }
  @Test
 void equipAndGet(){
  knight.equip(axe);
  assertEquals(axe,knight.getEquippedWeapon());
 }
 
 @Test
 void waitTurn() throws InterruptedException {

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