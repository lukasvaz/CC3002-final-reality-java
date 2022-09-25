package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;

public interface Mage extends PlayerCharacter {

    /**
     * Sets the Mage's current MP.
     */
     void setCurrentMp(final int currentMp) throws InvalidStatValueException ;

    /**
     * Returns the character's current MP.
     */
    int getcurrentMp() ;

    /**
     * Returns the Mage's max MP.
     */
     int getmaxMp();

}
