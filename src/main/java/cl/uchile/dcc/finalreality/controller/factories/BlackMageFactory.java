package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;


/**
 * This represents a Factory for WhiteMage´s creation.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public class BlackMageFactory implements IFactory {
  private int maxHp = 100;
  private int defense = 30;
  private String name = "BM";
  private int maxMp = 120;
  

  public BlackMage create(TurnsQueue queue) {
    return new BlackMage(this.name, this.defense, this.maxHp, this.maxMp, queue);
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
