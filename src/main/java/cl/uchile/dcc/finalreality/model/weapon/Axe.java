package cl.uchile.dcc.finalreality.model.weapon;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.AXE;

/**Creates an axe.*
 */
public class Axe  extends Weapon {
  private static final WeaponType type = AXE;
 
  public Axe(final String name, final int damage, final int weight) {
    super(name, damage, weight, type);
  }
}