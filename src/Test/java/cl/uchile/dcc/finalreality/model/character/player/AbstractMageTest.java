package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractMageTest {
 
 
 @Test
 void getcurrentMp() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  WhiteMage wmage= new WhiteMage("wmage",100,20,50,queue);
  BlackMage bmage=new BlackMage("bmage",100,20,1,queue);
  wmage.setCurrentMp(10);
  bmage.setCurrentMp(1);
  assertEquals(10,wmage.getcurrentMp());
  assertEquals(1,bmage.getcurrentMp());
 }
 @Test
 void setCurrentMp() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  WhiteMage wmage= new WhiteMage("wmage",100,20,50,queue);
  BlackMage bmage=new BlackMage("bmage",100,20,1,queue);
  bmage.setCurrentMp(1);
  wmage.setCurrentMp(1);
  assertEquals(1,wmage.getcurrentMp());
  assertEquals(1,bmage.getcurrentMp());
 }
 
 
 @Test
 void getmaxMp() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  WhiteMage wmage= new WhiteMage("wmage",100,20,50,queue);
  BlackMage bmage=new BlackMage("bmage",100,20,1,queue);
  wmage.setCurrentMp(1);
  bmage.setCurrentMp(1);
  assertEquals(50,wmage.getmaxMp());
  assertEquals(1,bmage.getmaxMp());
  
 }
}