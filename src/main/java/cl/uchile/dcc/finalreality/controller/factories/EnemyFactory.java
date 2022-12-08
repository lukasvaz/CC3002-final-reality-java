package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
/**
 *This factory class  is  used  to create a new Enemy.
 */

public class EnemyFactory  implements IFactory,Ienemyfactory {
  private int attack = 30;
  private int weight = 50;
  private int maxHp = 100;
  private int defense = 40;
  private String name = "E";

  
  public Enemy create(TurnsQueue queue) {
    return  new Enemy(this.name, this.weight, this.maxHp, this.defense, this.attack, queue);
  }
 
  @Override
 public void setWeight(int weight) {
    this.weight = weight;
  }
 
  @Override
  public void setAttack(int attack) {
    this.attack = attack;
  }
  
  public  void  setMaxHp(int maxHp) {
    this.maxHp = maxHp;
  }
 
  public  void  setDefense(int defense) {
    this.defense = defense;
  }
  
  public  void  setName(String name) {
    this.name = name;
  }
}
