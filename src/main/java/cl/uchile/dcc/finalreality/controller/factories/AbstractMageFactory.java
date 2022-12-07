package cl.uchile.dcc.finalreality.controller.factories;

/**
 * This represents an AbstractFactory for Mages.
 *
 * @author ~Lukas Vasquez Verdejo~
 */

public abstract class AbstractMageFactory extends AbstractFactory implements IMageFactory {
  int maxMp = 1;
  
  public void setMaxMp(int maxMp) {
    this.maxMp = maxMp;
  }
 
}
