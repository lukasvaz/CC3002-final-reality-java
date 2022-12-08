package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;


/**
 * This represents a Factory for creating Knights.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public class KnightFactory implements IFactory {
  
  
  private int maxHp = 200;
  private int defense = 100;
  private String name = "Knight";
  
  @Override
  public Knight create(TurnsQueue queue) {
    return new Knight(this.name, this.maxHp, this.defense, queue);
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
