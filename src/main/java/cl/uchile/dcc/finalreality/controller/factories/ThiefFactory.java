package cl.uchile.dcc.finalreality.controller.factories;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
/**
 * This represents a Factory for Thiefs creation.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public class ThiefFactory implements IFactory {
 
  private int maxHp = 150;
  private int defense = 70;
  private String name = "Thief";
 
  @Override
  public Thief create(TurnsQueue queue) {
    return new Thief(this.name, this.maxHp, this.defense, queue);
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
