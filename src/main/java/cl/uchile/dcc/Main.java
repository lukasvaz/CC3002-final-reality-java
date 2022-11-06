package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;



/**
 * On this class we will test all the methods  of this project.
 */
public class Main {
  /**
  * Run the tests.
  */
  public static void main(String[] args)
          throws InvalidStatValueException, InvalidWeaponAssignmentException {
    TurnsQueue turns = new TurnsQueue();
    
    // Create a weapon for playable characters, the weight is random
    // Create a character if each class
    //we equip weapon to the playable characters
    Weapon knife = new Knife("knife1", 0, 10);
    Thief thief = new Thief("thief1", 100, 10, turns);
    thief.equip(knife);
    
    Weapon axe = new Axe("axe1", 0, 20);
    Engineer engineer = new Engineer("engineer1", 100, 10, turns);
    engineer.equip(axe);
    
    Weapon wstaff = new Staff("white staff1", 0, 40);
    WhiteMage whitemage = new WhiteMage("white1", 50, 10, 50, turns);
    whitemage.equip(wstaff);
    
    Weapon bstaff = new Staff("black staff1", 0, 50);
    BlackMage blackmage = new BlackMage("black1", 50, 80, 50, turns);
    blackmage.equip(bstaff);
    
    Knight knight = new Knight("knight1", 100, 10, turns);
    Weapon sword = new Sword("sword1", 0, 30);
    knight.equip(sword);
    Enemy enemy = new Enemy("enemy1",  50, 10, 50, turns);
    
    // tesing equals() for each class
    System.out.println("testing equals:\n");
    System.out.println("First we create  a new set of characters "
                               + "with same parameters than the originals.....");
    
    var thief2 = new Thief("thief1", 100, 10, turns);
    var knight2 = new Knight("knight1", 100, 10, turns);
    var engineer2 = new Engineer("engineer1", 100, 10, turns);
    var blackmage2 = new BlackMage("black1", 50, 80, 50, turns);
    var whitemage2 = new WhiteMage("white1", 50, 10, 50, turns);
    var enemy2 = new Enemy("enemy1",  50, 10, 50, turns);
    
    System.out.println(thief2);
    System.out.println(knight2);
    System.out.println(engineer2);
    System.out.println(blackmage2);
    System.out.println(whitemage2);
    System.out.println(enemy2);
    System.out.printf("comparing thief1 with thief2 : %s %n", thief.equals(thief2));
    System.out.printf("comparing knight1 with knight2 : %s %n", knight.equals(knight2));
    System.out.printf("comparing engineer1 with engineer2 : %s %n", engineer.equals(engineer2));
    System.out.printf("comparing black_mage1 with "
                              + "blackmage2 : %s %n", blackmage.equals(blackmage2));
    System.out.printf("comparing white_mage1 with "
                              + "whitemage2 : %s %n", whitemage.equals(whitemage2));
    System.out.printf("comparing enemy1 with enemy2 : %s \n%n", enemy.equals(enemy2));
    System.out.println("Then we create  a new set of characters with different "
                               + "parameters than the originals.....");
    Thief thief3 = new Thief("Legolas", 120, 10, turns);
    Knight knight3 = new Knight("Aragon", 120, 10, turns);
    Engineer engineer3 = new Engineer("average_beuchefian", 120, 10, turns);
    BlackMage blackmage3 = new BlackMage("Sidious", 60, 80, 50, turns);
    WhiteMage whitemage3 = new WhiteMage("Gandalf", 60, 10, 50, turns);
    Enemy enemy3 = new Enemy("enemy1",  60, 15, 50, turns);
    System.out.println(thief2);
    System.out.println(knight2);
    System.out.println(engineer2);
    System.out.println(blackmage2);
    System.out.println(whitemage2);
    System.out.println(enemy2);
    System.out.printf("comparing thief1 with thief2 : %s %n", thief.equals(thief3));
    System.out.printf("comparing knight1 with knight2 : %s %n", knight.equals(knight3));
    System.out.printf("comparing engineer1 with engineer2 : %s %n", engineer.equals(engineer3));
    System.out.printf("comparing black_mage1 with "
                              + "blackmage2 : %s %n", blackmage.equals(blackmage3));
    System.out.printf("comparing white_mage1 with "
                              + "whitemage2 : %s %n", whitemage.equals(whitemage3));
    System.out.printf("comparing enemy1 with enemy2 : %s \n%n", enemy.equals(enemy3));
    // testing getters and setters of each class
    System.out.println("Testing getters() and setters(): \n");
    //get name
    System.out.println("playable character:\n");
    System.out.println("getName():");
    System.out.printf("  thief´s name: %s %n", thief.getName());
    System.out.printf("  knight´s name: %s %n", knight.getName());
    System.out.printf("  engineer´s name: %s %n", engineer.getName());
    System.out.printf("  black_mage´s name: %s %n", blackmage.getName());
    System.out.printf("  white_mage´s name: %s \n%n", whitemage.getName());
    //get defense
    System.out.println("getdefense():");
    System.out.printf("  thief´s defense: %s %n", thief.getDefense());
    System.out.printf("  knight´s defense: %s %n", knight.getDefense());
    System.out.printf("  engineer´s defense: %s %n", engineer.getDefense());
    System.out.printf("  black mage´s defense: %s %n", blackmage.getDefense());
    System.out.printf("  white mage´s defense: %s %n", whitemage.getDefense());
    
    //
    System.out.println("getCurrentHP():");
    System.out.printf("  thief´s current Hp: %d %n", thief.getCurrentHp());
    System.out.printf("  knight´s current Hp: %d %n", knight.getCurrentHp());
    System.out.printf("  engineer´s current Hp: %d %n", engineer.getCurrentHp());
    System.out.printf("  black_mage´s current Hp: %d %n", blackmage.getCurrentHp());
    System.out.printf("  white_mage´s current Hp: %d %n", whitemage.getCurrentHp());
    
    thief.setCurrentHp(1);
    knight.setCurrentHp(1);
    engineer.setCurrentHp(1);
    blackmage.setCurrentHp(1);
    whitemage.setCurrentHp(1);
    
    System.out.println("setting current Hp points to 1 in all playable classes :");
    System.out.printf(" new  thief´s current Hp: %d %n", thief.getCurrentHp());
    System.out.printf(" new  knight´s current Hp: %d %n", knight.getCurrentHp());
    System.out.printf(" new  engineer´s current Hp: %d %n", engineer.getCurrentHp());
    System.out.printf(" new  black_mage´s current Hp: %d %n", blackmage.getCurrentHp());
    System.out.printf(" new  white_mage´s current Hp: %d \n%n", whitemage.getCurrentHp());
    System.out.println("get equipedWeapon():");
    System.out.printf("  thief´s equipped weapon: %s %n", thief.getEquippedWeapon().getName());
    System.out.printf("  knight´s equipped weapon: %s %n", knight.getEquippedWeapon().getName());
    System.out.printf("  engineer´s equipped "
                              + "weapon: %s %n", engineer.getEquippedWeapon().getName());
    System.out.printf("  black_mage´s equipped "
                              + "weapon: %s %n", blackmage.getEquippedWeapon().getName());
    System.out.printf("  white_mage´s equipped "
                              + "weapon: %s \n%n", whitemage.getEquippedWeapon().getName());
    System.out.println("get  currentMp() and setCurrentMP() on Mages:");
    System.out.printf("  black_mage´s current Mana Points: %s %n", blackmage.getcurrentMp());
    System.out.printf("  white_mage´s current Mana Points: %s %n", whitemage.getcurrentMp());
    System.out.println(" setting black_mage´s  Mana Points to 1"); 
    System.out.println(" setting white_mage´s  Mana Points to 1 ");
    blackmage.setCurrentMp(1);
    whitemage.setCurrentMp(1);
    System.out.printf(" new  black_mage´s current Mana Points: %s %n", blackmage.getcurrentMp());
    System.out.printf(" new  white_mage´s current Mana Points: %s \n%n", whitemage.getcurrentMp());
    System.out.println("Enemy character's getters() and setters():\n ");
    System.out.printf("  enemy's name: %s %n", enemy.getName());
    System.out.printf("  enemy's weight: %s %n", enemy.getWeight());
    System.out.printf("  enemy's current: %s %n", enemy.getCurrentHp());
    System.out.printf("  enemy's defense: %s %n", enemy.getDefense());
    System.out.printf("  enemy's maxHp: %s %n", enemy.getMaxHp());
    System.out.printf("  enemy's currentHp: %s %n", enemy.getCurrentHp());
    System.out.println("    setting Hp to 1: ");
    enemy.setCurrentHp(1);
    System.out.printf("  enemy's Hp : %s  \n%n", enemy.getCurrentHp());
    System.out.println("Weapon's getters() and setters(): ");
    System.out.printf("  knife's  name: %s %n", knife.getName());
    System.out.printf("  axe's weight: %s %n", axe.getName());
    System.out.printf("  sword's current: %s %n", sword.getName());
    System.out.printf("  w_staff's defense: %s %n", wstaff.getName());
    System.out.printf("  b_staff's maxHp: %s \n%n", bstaff.getName());
    System.out.printf("  knife's  weight: %s %n", knife.getWeight());
    System.out.printf("  axe's weight: %s %n", axe.getWeight());
    System.out.printf("  sword's weight: %s %n", sword.getWeight());
    System.out.printf("  w_staff's weight: %s %n", wstaff.getWeight());
    System.out.printf("  b_staff's weight: %s \n%n", bstaff.getWeight());
    System.out.println(" Testing equals in weapons: ");
    System.out.println("First we create  a new set of characters "
                               + "with same parameters than the originals.....");
    var knife2 = new Knife("knife1", 0, 10);
    var axe2 = new Axe("axe1", 0, 20);
    var sword2 = new Sword("sword1", 0, 30);
    var wstaff2 = new Staff("white staff1", 0, 40);
    var bstaff2 = new Staff("black staff1", 0, 50);
    System.out.println(knife2);
    System.out.println(axe2);
    System.out.println(sword2);
    System.out.println(wstaff2);
    System.out.println(bstaff2);
    System.out.printf("comparing knife with knife2 : %s %n", knife.equals(knife2));
    System.out.printf("comparing axe with axe2 : %s %n", axe.equals(axe2));
    System.out.printf("comparing sword with sword2 : %s %n", sword.equals(sword2));
    System.out.printf("comparing w_staff with wstaff2 : %s %n", wstaff.equals(wstaff2));
    System.out.printf("comparing b_staff with bstaff2 : %s %n", bstaff.equals(bstaff2));
    System.out.println("Then we create  a new set of characters "
                               + "with different parameters than the originals.....");
    var knife3 = new Knife("cuchila", 0, 10);
    var axe3 = new Axe("twosidedaxe", 0, 20);
    var sword3 = new Sword("scalibur", 0, 30);
    var wstaff3 = new Staff("woodstaff", 0, 40);
    var bstaff3 = new Staff("steel staff1", 0, 50);
    System.out.println(knife3);
    System.out.println(axe3);
    System.out.println(sword3);
    System.out.println(wstaff3);
    System.out.println(bstaff3);
    System.out.printf("comparing knife with knife3 : %s %n", knife.equals(knife3));
    System.out.printf("comparing axe with axe3 : %s %n", axe.equals(axe3));
    System.out.printf("comparing sword with sword3 : %s %n", sword.equals(sword3));
    System.out.printf("comparing w_staff with wstaff3 : %s %n", wstaff.equals(wstaff3));
    System.out.printf("comparing b_staff with bstaff3 : %s %n", bstaff.equals(bstaff3));
  }
}
