package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args)
            throws InvalidStatValueException  {


        TurnsQueue queue = new TurnsQueue();
        AbstractMage mage1= new BlackMage("lukas",30,30,80,queue);
        AbstractMage mage2= new WhiteMage("lukas",30,30,80,queue);

        System.out.println(mage1.getEquippedWeapon());
        System.out.println(mage1.equals(mage2));



    }

}
