package cl.uchile.dcc.finalreality.model.effects;


import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;

/**
 * This interface represent a set of classes which recieves Effects
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Lukas Vasquez~
 */
public interface EffectsObservable {
 
 void notifyEffects() throws InterruptedException, NullWeaponException;
 
}
