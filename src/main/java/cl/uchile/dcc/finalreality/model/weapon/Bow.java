package cl.uchile.dcc.finalreality.model.weapon;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.BOW;

/**Creates an axe.*
 */
public class Bow  extends Weapon {
  private static final WeaponType type = BOW;
 
  public Bow(final String name, final int damage, final int weight) {
    super(name, damage, weight, type);
  }
}