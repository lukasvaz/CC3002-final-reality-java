package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
/**
 *This factory class  is  used  to create a new Enemy.
 */

public class EnemyFactory extends AbstractFactory implements Ienemyfactory {
  int attack=1;
  int weight = 1;
 
  @Override
 public Enemy create(TurnsQueue queue) {
    return  new Enemy(super.name, this.weight, super.maxHp, super.defense, this.attack, queue);
  }
 
  @Override
 public void setWeight(int weight) {
    this.weight = weight;
  }
 
  @Override
 public void setAttack (int attack) {
  this.attack = attack;
 }
}
