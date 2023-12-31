package cl.uchile.dcc.finalreality.model.weapon;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.SWORD;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.util.Objects;




/**
 * A class that holds all the information of a Bow.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public class Sword implements Weapon {
  final  String name;
  final int damage;
  final int weight;
  final WeaponType type = SWORD;
  
  /**Creates a SWORD.*
   *
   *    @param name
   *         the sword's name
   *     @param damage
   *         the damage due the weapon
   *     @param weight
   *         the character's defense
   *
   *      the type of the weapon is sword
   */
  public Sword(final String name, final int damage, final int weight) {
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
    p.equipSword(this);
  }
  
  
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Sword sword)) {
      return false;
    }
    return hashCode() == sword.hashCode()
                   && damage == sword.damage
                   && weight == sword.weight
                   && name.equals(sword.name)
                   && type == sword.type;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(Weapon.class, name, damage, weight, type);
  }
  
  @Override
  public String toString() {
    return "Sword{name='%s', damage=%d, weight=%d, type=%s}"
                   .formatted(name, damage, weight, type);
  }
  
  @Override
  public int magicAttack() {
    return this.getDamage();
  }
  
  
}
