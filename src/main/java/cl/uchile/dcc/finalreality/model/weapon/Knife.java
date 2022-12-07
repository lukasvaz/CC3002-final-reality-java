package cl.uchile.dcc.finalreality.model.weapon;

import static cl.uchile.dcc.finalreality.model.weapon.WeaponType.KNIFE;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.util.Objects;



/**
 * A class that holds all the information of a Bow.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */

public class Knife implements Weapon {
  final  String name;
  final int damage;
  final int weight;
  final WeaponType type = KNIFE;
 
  /**Creates a KNIFE.*
  *
  *    @param name
  *         the axe's name
  *     @param damage
  *         the damage due the weapon
  *     @param weight
  *         the character's defense
  *
  *      the type of the weapon is KNIFE
  */
  public Knife(final String name, final int damage, final int weight) {
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
    p.equipKnife(this);
  }
  
  
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Knife knife)) {
      return false;
    }
    return hashCode() == knife.hashCode()
                 && damage == knife.damage
                 && weight == knife.weight
                 && name.equals(knife.name)
                 && type == knife.type;
  }
 
  @Override
   public int hashCode() {
    return Objects.hash(Weapon.class, name, damage, weight, type);
  }
 
  @Override
    public String toString() {
    return "Knife{name='%s', damage=%d, weight=%d, type=%s}"
                 .formatted(name, damage, weight, type);
  }
  
  @Override
  public int magicAttack() {
    return this.getDamage()/2;
  }
  
  
  
}

