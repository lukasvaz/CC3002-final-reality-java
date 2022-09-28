package cl.uchile.dcc.finalreality.model;

import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

public class TurnsQueue {
    final @NotNull BlockingQueue<GameCharacter> queue;
    public TurnsQueue(){
        this.queue=new LinkedBlockingQueue<>();
    }

    public BlockingQueue<GameCharacter> get_queue(){
        return  this.queue;
    }


    public void push(AbstractCharacter character) {
        try {
           this.queue.put(character);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void listen (AbstractCharacter character){

    }
}
