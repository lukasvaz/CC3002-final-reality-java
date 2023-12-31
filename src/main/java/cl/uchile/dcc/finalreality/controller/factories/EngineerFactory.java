package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;

/**
 * This represents a Factory for  Engineers creation.
 *
 * @author ~Lukas Vasquez Verdejo~
 */
public class EngineerFactory implements IFactory {
 
  private int maxHp = 150;
  private int defense = 80;
  private String name = "Engineer";
  
  @Override
 public Engineer create(TurnsQueue queue) {
    return new Engineer(this.name, this.maxHp, this.defense, queue);
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
