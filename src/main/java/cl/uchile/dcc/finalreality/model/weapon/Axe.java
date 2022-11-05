package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.AXE;

/**
 * A class that holds all the information of an Axe.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public class  Axe implements Weapon {
  
  private final  String name;
  private  final int damage;
  private  final int weight;
  private final WeaponType type = AXE;
  
  /**Creates an axe.*
   *
   *    @param name
   *         the axe's name
   *     @param damage
   *         the damage due the weapon
   *     @param weight
   *         the character's defense
   *
   *      the type of the weapon is.  AXE
   */
  public Axe(final String name, final int damage, final int weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }
  
  /**
   * Returns the name of the weapon.
   */
  public String getName() {
    return name;
  }
  
  /**
   * Returns the damageof the weapon.
   */
  public int getDamage() {
    return damage;
  }
  
  /**
   * Returns the weight of the weapon.
   */
  public int getWeight() {
    return weight;
  }
  
  /**
   * Returns the type of the weapon.
   */
  public WeaponType getType() {
    return type;
  }
  
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Axe axe)) {
      return false;
    }
    return hashCode() == axe.hashCode()
                   && damage == axe.damage
                   && weight == axe.weight
                   && name.equals(axe.name)
                   && type == axe.type;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(Weapon.class, name, damage, weight, type);
  }
  
  @Override
  public String toString() {
    return "Axe{name='%s', damage=%d, weight=%d, type=%s}"
                   .formatted(name, damage, weight, type);
  }
}
