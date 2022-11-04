package cl.uchile.dcc.finalreality.model;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnsQueueTest {
 
 @Test
 void get_queue() {
  TurnsQueue queue= new TurnsQueue();
  assertEquals(queue.queue,queue.get_queue());
 }
 
 @Test
 void push() throws InvalidStatValueException {
  TurnsQueue queue= new TurnsQueue();
  Enemy enemy= new Enemy("enemy",20,20,20,queue);
  queue.push(enemy);
  assertEquals(enemy,queue.get_queue().poll());
 }
}