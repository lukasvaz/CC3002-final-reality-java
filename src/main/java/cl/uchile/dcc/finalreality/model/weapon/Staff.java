package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.STAFF;


/**
 * A class that holds all the information of a Staff.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Lukas Vasquez~
 * */
public class Staff implements  Weapon {
  final  String name;
  final int damage;
  final int weight;
  final WeaponType type = STAFF;
 
  /**Creates a Staff.*
  *
  *    @param name
  *         the axe's name
  *     @param damage
  *         the damage due the weapon
  *     @param weight
  *         the character's defense
  *
  *      the type of the weapon is BOW
  */
  public Staff(final String name, final int damage, final int weight) {
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
    if (!(o instanceof final Staff staff)) {
      return false;
    }
    return hashCode() == staff.hashCode()
                 && damage == staff.damage
                 && weight == staff.weight
                 && name.equals(staff.name)
                 && type == staff.type;
  }
 
  @Override
  public int hashCode() {
    return Objects.hash(Weapon.class, name, damage, weight, type);
  }
 
  @Override
   public String toString() {
    return "Weapon{name='%s', damage=%d, weight=%d, type=%s}"
                 .formatted(name, damage, weight, type);
  }
}
