package cl.uchile.dcc.finalreality.model.weapon;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.STAFF;

/**Creates an axe.*
 */
public class Staff  extends Weapon {
  private static final WeaponType type = STAFF;
 
  public Staff(final String name, final int damage, final int weight) {
    super(name, damage, weight, type);
  }
 }