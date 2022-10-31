package cl.uchile.dcc.finalreality.model.weapon;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.KNIFE;

/**Creates an axe.*
 */
public class Knife  extends Weapon {
  private static final WeaponType type = KNIFE;
 
  public Knife(final String name, final int damage, final int weight) {
    super(name, damage, weight, type);
  }
 }