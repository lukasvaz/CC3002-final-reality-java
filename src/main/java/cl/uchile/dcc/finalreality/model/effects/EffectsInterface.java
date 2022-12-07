package cl.uchile.dcc.finalreality.model.effects;


import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.AbstractMage;

/**
 * This interdace  represents the effects associated to  differents magic attacks.
 *
 * @author ~Lukas Vasquez~
 */
public interface EffectsInterface {

 void updateEffect(Enemy e);
 
}
