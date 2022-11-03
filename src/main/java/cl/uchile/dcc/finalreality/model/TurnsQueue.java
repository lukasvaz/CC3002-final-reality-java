package cl.uchile.dcc.finalreality.model;

import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import java.util.concurrent.*;
import org.jetbrains.annotations.NotNull;


/**
 * A class that manages mathods from  turn´s system.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Lukas Vasquez~
 */


public class TurnsQueue {
  final @NotNull BlockingQueue<AbstractCharacter> queue;
  /**
   * Creates a Queue Object that recieves messages from the character classes .
   *
   */
  
  public TurnsQueue() {
    this.queue = new LinkedBlockingQueue<>();
  }
  /**
   * Returns the queue object itself.
   */
  
  public BlockingQueue<AbstractCharacter> get_queue() {
    return  this.queue;
  }
  /**
   * Add a Character to the queue.
   */
  
  public void push(AbstractCharacter character) {
    try {
      this.queue.put(character);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
