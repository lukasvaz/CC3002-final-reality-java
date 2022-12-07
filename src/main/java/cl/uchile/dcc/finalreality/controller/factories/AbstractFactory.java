package cl.uchile.dcc.finalreality.controller.factories;

/**
 * This represents an AbstractFactory for common methods.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public  abstract class AbstractFactory implements IFactory {
 
  int maxHp;
  int defense;
  String name;
  
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
