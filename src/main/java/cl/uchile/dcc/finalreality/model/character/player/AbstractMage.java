package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractMage extends AbstractPlayerCharacter implements PlayerMage {
    protected int currentMp;
    protected final int maxMp;

    /**
     * Creates a new Mage.
     * This constructor is <b>protected</b>, because it'll only be used by subclasses.
     *
     * @param name
     *     the Mage's name
     * @param maxHp
     *     the Mage's max hp
     * @param defense
     *     the Mage's defense
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     */
    protected AbstractMage(final @NotNull String name, final int maxHp, final int defense,
                        int maxMp, final @NotNull TurnsQueue turnsQueue)
            throws InvalidStatValueException {
        super(name, maxHp, defense, turnsQueue);
        this.maxMp = maxMp;
        this.currentMp = maxMp;
    }

    // region : ACCESSORS
    /**
     * Sets the Mage's current MP.
     */
    public void setCurrentMp(final int currentMp) throws InvalidStatValueException {
        Require.statValueAtLeast(0, currentMp, "Current MP");
        Require.statValueAtMost(maxMp, currentMp, "Current MP");
        this.currentMp = currentMp;
    }

    /**
     * Returns the character's current MP.
     */
    public int getcurrentMp() {
        return currentMp;
    }

    /**
     * Returns the Mage's max MP.
     */
    public int getmaxMp() {
        return maxMp;
    }
}
