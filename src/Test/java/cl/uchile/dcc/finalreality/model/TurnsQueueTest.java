package cl.uchile.dcc.finalreality.model;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnsQueueTest {
 TurnsQueue queue;
 Enemy enemy;
 @BeforeEach
 void setup() throws InvalidStatValueException {
  queue= new TurnsQueue();
  enemy= new Enemy("enemy",20,20,20,queue);
 }
 
 @Test
 void get_queue() {
  assertEquals(queue.queue,queue.get_queue());
 }
 
 @Test
 void push() throws InvalidStatValueException {
  queue.push(enemy);
  assertEquals(enemy,queue.get_queue().poll());
 }
}