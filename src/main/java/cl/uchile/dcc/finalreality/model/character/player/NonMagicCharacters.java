package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.magic.MagicInterface;
import org.jetbrains.annotations.NotNull;

public abstract class NonMagicCharacters extends AbstractPlayerCharacter {
 
 /**
  * Creates a new character.
  * This constructor is <b>protected</b>, because it'll only be used by subclasses.
  *
  * @param name       the character's name
  * @param maxHp      the character's max hp
  * @param defense    the character's defense
  * @param turnsQueue the queue with the characters waiting for their turn
  */
 
  protected NonMagicCharacters(@NotNull String name, int maxHp, int defense, @NotNull TurnsQueue turnsQueue) throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }
 
  public void implementsMagic (MagicInterface magic, GameCharacter character) throws NotImplementsMagicException {
    magic.nonMagicCharacterOn(this,character);
  }
 
 @Override
 public void selectTurn() {
  this.controller.getState().characterTurn(this.controller);
  
 }
}
