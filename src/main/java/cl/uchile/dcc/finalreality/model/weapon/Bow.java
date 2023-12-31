package cl.uchile.dcc.finalreality.model.weapon;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.BOW;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.util.Objects;



/**
 * A class that holds all the information of a Bow.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public class Bow implements Weapon {
  private final  String name;
  private  final int damage;
  private  final int weight;
  private final WeaponType type = BOW;
  
  /**Creates a BOW.*
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
  public Bow(final String name, final int damage, final int weight) {
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
  public void equippedby(PlayerCharacter p) throws InvalidWeaponAssignmentException {
    p.equipBow(this);
  }
  
  
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Bow bow)) {
      return false;
    }
    return hashCode() == bow.hashCode()
                   && damage == bow.damage
                   && weight == bow.weight
                   && name.equals(bow.name)
                   && type == bow.type;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(Weapon.class, name, damage, weight, type);
  }
  
  @Override
  public String toString() {
    return "Bow{name='%s', damage=%d, weight=%d, type=%s}"
                   .formatted(name, damage, weight, type);
  }
  
  @Override
  public int magicAttack() {
    return this.getDamage()/2;
  }
  
  
}
