package cl.uchile.dcc.finalreality.model.weapon;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.SWORD;

/**Creates a sword.*
 */
public class Sword  extends Weapon {
  private static final WeaponType type = SWORD;
 
  public Sword(final String name, final int damage, final int weight) {
    super(name, damage, weight, type);
  
  }
}
