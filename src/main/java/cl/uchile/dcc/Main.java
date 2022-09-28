package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.AbstractMage;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;

import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args)
            throws InvalidStatValueException  {
        TurnsQueue turns = new TurnsQueue();
        Random rng = new Random();

            // Create a weapon for playable characters, the weight is random
            var knife= new Weapon("knife1", 0, 10, WeaponType.KNIFE);
            var axe = new Weapon("axe1", 0, 20, WeaponType.AXE);
            var sword = new Weapon("sword1", 0, 30, WeaponType.SWORD);
            var w_staff = new Weapon("white staff1", 0, 40, WeaponType.STAFF);
            var b_staff = new Weapon("black staff1", 0, 50, WeaponType.STAFF);
            // Create a character if each class
            var thief = new Thief("thief1", 100, 10, turns);
            var knight = new Knight("knight1", 100, 10, turns);
            var engineer = new Engineer("engineer1", 100, 10, turns);
            var black_mage =new BlackMage("black1", 50, 80, 50,turns);
            var white_mage =new WhiteMage("white1", 50, 10, 50,turns);
            var enemy= new Enemy("enemy1",  50, 10, 50,turns);

            //we equip weapon to the playable characters
            thief.equip(knife);
            knight.equip(sword);
            engineer.equip(axe);
            black_mage.equip(b_staff);
            white_mage.equip(w_staff);
             // tesing equals() for each class
        System.out.println("testing equals:\n");
        System.out.println("First we create  a new set of characters with same parameters than the originals.....");

        var thief2 = new Thief("thief1", 100, 10, turns);
        var knight2 = new Knight("knight1", 100, 10, turns);
        var engineer2 = new Engineer("engineer1", 100, 10, turns);
        var black_mage2 = new BlackMage("black1", 50, 80, 50,turns);
        var white_mage2 = new WhiteMage("white1", 50, 10, 50,turns);
        var enemy2= new Enemy("enemy1",  50, 10, 50,turns);
        System.out.println(thief2.toString());
        System.out.println(knight2.toString());
        System.out.println(engineer2.toString());
        System.out.println(black_mage2.toString());
        System.out.println(white_mage2.toString());
        System.out.println(enemy2.toString());


        System.out.println(String.format("comparing thief1 with thief2 : %s " ,thief.equals(thief2)));
        System.out.println(String.format("comparing knight1 with knight2 : %s " ,knight.equals(knight2)));
        System.out.println(String.format("comparing engineer1 with engineer2 : %s " ,engineer.equals(engineer2)));
        System.out.println(String.format("comparing black_mage1 with black_mage2 : %s " ,black_mage.equals(black_mage2)));
        System.out.println(String.format("comparing white_mage1 with white_mage2 : %s " ,white_mage.equals(white_mage2)));
        System.out.println(String.format("comparing enemy1 with enemy2 : %s \n" ,enemy.equals(enemy2)));


        System.out.println("Then we create  a new set of characters with different parameters than the originals.....");

        var thief3 = new Thief("Legolas", 120, 10, turns);
        var knight3 = new Knight("Aragon", 120, 10, turns);
        var engineer3 = new Engineer("average_beuchefian", 120, 10, turns);
        var black_mage3 = new BlackMage("Sidious", 60, 80, 50,turns);
        var white_mage3 = new WhiteMage("Gandalf", 60, 10, 50,turns);
        var enemy3= new Enemy("enemy1",  60, 15, 50,turns);
        System.out.println(thief2.toString());
        System.out.println(knight2.toString());
        System.out.println(engineer2.toString());
        System.out.println(black_mage2.toString());
        System.out.println(white_mage2.toString());
        System.out.println(enemy2.toString());
        System.out.println(String.format("comparing thief1 with thief2 : %s " ,thief.equals(thief3)));
        System.out.println(String.format("comparing knight1 with knight2 : %s " ,knight.equals(knight3)));
        System.out.println(String.format("comparing engineer1 with engineer2 : %s " ,engineer.equals(engineer3)));
        System.out.println(String.format("comparing black_mage1 with black_mage2 : %s " ,black_mage.equals(black_mage3)));
        System.out.println(String.format("comparing white_mage1 with white_mage2 : %s " ,white_mage.equals(white_mage3)));
        System.out.println(String.format("comparing enemy1 with enemy2 : %s \n" ,enemy.equals(enemy3)));



            // testing getters and setters of each class
            System.out.println("Testing getters() and setters(): \n");
            //get name
             System.out.println("playable character:\n");
            System.out.println("getName():");
            System.out.println(String.format("  thief´s name: %s ",thief.getName()));
            System.out.println(String.format("  knight´s name: %s ",knight.getName()));
            System.out.println(String.format("  engineer´s name: %s ",engineer.getName()));
            System.out.println(String.format("  black_mage´s name: %s ",black_mage.getName()));
            System.out.println(String.format("  white_mage´s name: %s \n",white_mage.getName()));
            //get defense
        System.out.println("getdefense():");
            System.out.println(String.format("  thief´s defense: %s " ,thief.getDefense()));
            System.out.println(String.format("  knight´s defense: %s " ,knight.getDefense()));
        System.out.println(String.format("  engineer´s defense: %s " ,engineer.getDefense()));
        System.out.println(String.format("  black mage´s defense: %s " ,black_mage.getDefense()));
        System.out.println(String.format("  white mage´s defense: %s " ,white_mage.getDefense()));
        //
        System.out.println("getCurrentHP():");
        System.out.println(String.format("  thief´s current Hp: %d " ,thief.getCurrentHp()));
        System.out.println(String.format("  knight´s current Hp: %d " ,knight.getCurrentHp()));
        System.out.println(String.format("  engineer´s current Hp: %d " ,engineer.getCurrentHp()));
        System.out.println(String.format("  black_mage´s current Hp: %d " ,black_mage.getCurrentHp()));
        System.out.println(String.format("  white_mage´s current Hp: %d " ,white_mage.getCurrentHp()));


        thief.setCurrentHp(1);
        knight.setCurrentHp(1);
        engineer.setCurrentHp(1);
        black_mage.setCurrentHp(1);
        white_mage.setCurrentHp(1);

        System.out.println("setting current Hp points to 1 in all playable classes :");
        System.out.println(String.format(" new  thief´s current Hp: %d " ,thief.getCurrentHp()));
        System.out.println(String.format(" new  knight´s current Hp: %d " ,knight.getCurrentHp()));
        System.out.println(String.format(" new  engineer´s current Hp: %d " ,engineer.getCurrentHp()));
        System.out.println(String.format(" new  black_mage´s current Hp: %d " ,black_mage.getCurrentHp()));
        System.out.println(String.format(" new  white_mage´s current Hp: %d \n" ,white_mage.getCurrentHp()));

        System.out.println("get equipedWeapon():");
        System.out.println(String.format("  thief´s equipped weapon: %s " ,thief.getEquippedWeapon().getName()));
        System.out.println(String.format("  knight´s equipped weapon: %s " ,knight.getEquippedWeapon().getName()));
        System.out.println(String.format("  engineer´s equipped weapon: %s " ,engineer.getEquippedWeapon().getName()));
        System.out.println(String.format("  black_mage´s equipped weapon: %s " ,black_mage.getEquippedWeapon().getName()));
        System.out.println(String.format("  white_mage´s equipped weapon: %s \n" ,white_mage.getEquippedWeapon().getName()));

        System.out.println("get  currentMp() and setCurrentMP() on Mages:");
        System.out.println(String.format("  black_mage´s current Mana Points: %s " ,black_mage.getcurrentMp()));
        System.out.println(String.format("  white_mage´s current Mana Points: %s " ,white_mage.getcurrentMp()));
        System.out.println(" setting black_mage´s  Mana Points to 1"); 
        System.out.println(" setting white_mage´s  Mana Points to 1 ");
        black_mage.setCurrentMp(1);
        white_mage.setCurrentMp(1);
        System.out.println(String.format(" new  black_mage´s current Mana Points: %s " ,black_mage.getcurrentMp()));
        System.out.println(String.format(" new  white_mage´s current Mana Points: %s \n" ,white_mage.getcurrentMp()));
        System.out.println("Enemy character's getters() and setters():\n ");
        System.out.println(String.format("  enemy's name: %s " ,enemy.getName()));
        System.out.println(String.format("  enemy's weight: %s " ,enemy.getWeight()));
        System.out.println(String.format("  enemy's current: %s " ,enemy.getCurrentHp()));
        System.out.println(String.format("  enemy's defense: %s " ,enemy.getDefense()));
        System.out.println(String.format("  enemy's maxHp: %s " ,enemy.getMaxHp()));
        System.out.println(String.format("  enemy's currentHp: %s " ,enemy.getCurrentHp()));
        System.out.println("    setting Hp to 1: ");
        enemy.setCurrentHp(1);
        System.out.println(String.format("  enemy's Hp : %s  \n" ,enemy.getCurrentHp()));

        System.out.println("Weapon's getters() and setters(): ");
        System.out.println(String.format("  knife's  name: %s " ,knife.getName()));
        System.out.println(String.format("  axe's weight: %s " ,axe.getName()));
        System.out.println(String.format("  sword's current: %s " ,sword.getName()));
        System.out.println(String.format("  w_staff's defense: %s " ,w_staff.getName()));
        System.out.println(String.format("  b_staff's maxHp: %s \n" ,b_staff.getName()));

        System.out.println(String.format("  knife's  weight: %s " ,knife.getWeight()));
        System.out.println(String.format("  axe's weight: %s " ,axe.getWeight()));
        System.out.println(String.format("  sword's weight: %s " ,sword.getWeight()));
        System.out.println(String.format("  w_staff's weight: %s " ,w_staff.getWeight()));
        System.out.println(String.format("  b_staff's weight: %s \n" ,b_staff.getWeight()));



        System.out.println(" Testing equals in weapons: ");
        System.out.println("First we create  a new set of characters with same parameters than the originals.....");
        var knife2= new Weapon("knife1", 0, 10, WeaponType.KNIFE);
        var axe2 = new Weapon("axe1", 0, 20, WeaponType.AXE);
        var sword2 = new Weapon("sword1", 0, 30, WeaponType.SWORD);
        var w_staff2 = new Weapon("white staff1", 0, 40, WeaponType.STAFF);
        var b_staff2 = new Weapon("black staff1", 0, 50, WeaponType.STAFF);
        System.out.println(knife2.toString());
        System.out.println(axe2.toString());
        System.out.println(sword2.toString());
        System.out.println(w_staff2.toString());
        System.out.println(b_staff2.toString());

        System.out.println(String.format("comparing knife with knife2 : %s " ,knife.equals(knife2)));
        System.out.println(String.format("comparing axe with axe2 : %s " ,axe.equals(axe2)));
        System.out.println(String.format("comparing sword with sword2 : %s " ,sword.equals(sword2)));
        System.out.println(String.format("comparing w_staff with w_staff2 : %s " ,w_staff.equals(w_staff2)));
        System.out.println(String.format("comparing b_staff with b_staff2 : %s " ,b_staff.equals(b_staff2)));

         System.out.println("Then we create  a new set of characters with different parameters than the originals.....");
        var knife3= new Weapon("cuchila", 0, 10, WeaponType.KNIFE);
        var axe3 = new Weapon("twosidedaxe", 0, 20, WeaponType.AXE);
        var sword3 = new Weapon("scalibur", 0, 30, WeaponType.SWORD);
        var w_staff3 = new Weapon("woodstaff", 0, 40, WeaponType.STAFF);
        var b_staff3 = new Weapon("steel staff1", 0, 50, WeaponType.STAFF);
        System.out.println(knife3.toString());
        System.out.println(axe3.toString());
        System.out.println(sword3.toString());
        System.out.println(w_staff3.toString());
        System.out.println(b_staff3.toString());
        System.out.println(String.format("comparing knife with knife3 : %s " ,knife.equals(knife3)));
        System.out.println(String.format("comparing axe with axe3 : %s " ,axe.equals(axe3)));
        System.out.println(String.format("comparing sword with sword3 : %s " ,sword.equals(sword3)));
        System.out.println(String.format("comparing w_staff with w_staff3 : %s " ,w_staff.equals(w_staff3)));
        System.out.println(String.format("comparing b_staff with b_staff3 : %s " ,b_staff.equals(b_staff3)));

     

   







         

        


            }


}
