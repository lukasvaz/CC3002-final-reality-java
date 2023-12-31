package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractMageTest {
 TurnsQueue queue;
 WhiteMage wmage;
 BlackMage bmage;
 
 
 @BeforeEach
 void setup() throws InvalidStatValueException {
  queue= new TurnsQueue();
  wmage= new WhiteMage("wmage",100,20,50,queue);
  bmage=new BlackMage("bmage",100,20,1,queue);
 }
 @Test
 void getcurrentMp() throws InvalidStatValueException {
  wmage.setCurrentMp(10);
  bmage.setCurrentMp(1);
  assertEquals(10,wmage.getcurrentMp());
  assertEquals(1,bmage.getcurrentMp());
 }
 @Test
 void setCurrentMp() throws InvalidStatValueException {
  bmage.setCurrentMp(1);
  wmage.setCurrentMp(1);
  assertEquals(1,wmage.getcurrentMp());
  assertEquals(1,bmage.getcurrentMp());
  assertThrows(InvalidStatValueException.class, ()-> {bmage.setCurrentMp(-1);});
  assertThrows(InvalidStatValueException.class, ()-> {wmage.setCurrentMp(51);});
  
 }
 
 
 @Test
 void getmaxMp() throws InvalidStatValueException {
  assertEquals(50,wmage.getmaxMp());
  assertEquals(1,bmage.getmaxMp());
  wmage.setCurrentMp(1);
  bmage.setCurrentMp(1);
  assertEquals(50,wmage.getmaxMp());
  assertEquals(1,bmage.getmaxMp());
  
 }
 @Test
 void testinvalidexception() throws InvalidStatValueException {
  assertThrows(InvalidStatValueException.class, ()-> {new BlackMage("name",20,20,-100,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new BlackMage("name",20,0,100,queue);});
  assertThrows(InvalidStatValueException.class, ()-> {new BlackMage("name",-1,100,100,queue);});
 }
}