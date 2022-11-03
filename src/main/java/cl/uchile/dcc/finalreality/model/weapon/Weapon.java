package cl.uchile.dcc.finalreality.model.weapon;

/**
 * A class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public interface Weapon {
  /**
   * Returns the name of the weapon.
   */
  
  String getName();

  /**
   * Returns the damageof the weapon.
   */
  int getDamage();

  /**
   * Returns the weight of the weapon.
   */
  int getWeight();
  /**
   * Returns the type of the weapon.
   *
   */
  
  WeaponType getType();
  
}
