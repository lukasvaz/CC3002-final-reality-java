package cl.uchile.dcc.finalreality.model.factories;

import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import org.jetbrains.annotations.NotNull;

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
