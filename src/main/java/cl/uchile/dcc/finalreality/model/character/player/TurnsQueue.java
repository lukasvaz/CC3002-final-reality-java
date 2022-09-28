package cl.uchile.dcc.finalreality.model.character.player;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

public class TurnsQueue {
    protected ScheduledExecutorService scheduledExecutor;
    final @NotNull BlockingQueue<GameCharacter> queue;
    public TurnsQueue(){
        this.queue=new LinkedBlockingQueue<>();
    }

    public BlockingQueue<GameCharacter> get_queue(){
        return  this.queue;
    }

    public void push(Enemy enemy) {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutor.schedule(
                /* command = */ this::addToQueue,
                /* delay = */ enemy.getWeight() / 10,
                /* unit = */ TimeUnit.SECONDS);

    }

    private void addToQueue(AbstractCharacter character){
    try {
           this.queue.put(character);
        } catch (Exception e) {
            e.printStackTrace();
        }
        scheduledExecutor.shutdown();
    }

}
