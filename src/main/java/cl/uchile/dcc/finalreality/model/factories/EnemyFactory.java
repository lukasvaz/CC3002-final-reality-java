package cl.uchile.dcc.finalreality.model.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
/**
 *This factory class  is  used  to create a new Enemy.
 */

public class EnemyFactory extends AbstractFactory implements Ienemyfactory {
  int weight = 1;
 
  @Override
 public Enemy create(TurnsQueue queue) {
    return  new Enemy(super.name, this.weight, super.maxHp, super.defense , queue);
  }
 
  @Override
 public void setWeight(int weight) {
    this.weight = weight;
  }
}
