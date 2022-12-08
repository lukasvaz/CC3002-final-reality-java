package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;


/**
 * This represents a Factory for WhiteMage´s creation.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public class WhiteMageFactory implements IFactory {
  private int maxHp = 180;
  private int defense = 50;
  private String name = "WhiteMage";
  private int maxMp = 200;
  
  @Override
 public WhiteMage create(TurnsQueue queue) {
    return new WhiteMage(this.name, this.maxHp, this.defense, this.maxMp, queue);
  }
  
  public void setMaxMp(int maxMp) {
    this.maxMp = maxMp;
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
