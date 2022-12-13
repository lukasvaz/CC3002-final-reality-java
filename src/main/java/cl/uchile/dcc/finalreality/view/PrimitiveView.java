package cl.uchile.dcc.finalreality.view;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.factories.IFactory;
import cl.uchile.dcc.finalreality.controller.factories.KnightFactory;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerMage;
import cl.uchile.dcc.finalreality.model.effects.EffectsInterface;
import cl.uchile.dcc.finalreality.model.magic.MagicInterface;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

import java.util.ArrayList;

public class PrimitiveView implements ViewInterface {
  @Override
 public IFactory askForCharacter() {
    return new KnightFactory();
  }
 
  @Override
 public void showLoading() {
  System.out.println("Loading..");
  }
 
  @Override
 public void showTurn(GameCharacter g) {
    System.out.println( "Turn of :\n" + g);
  }
 
 @Override
 public void showCharacter(String name, int currHp, int defense, Weapon weapon) {
  System.out.println("updated "+ name);
 }
 
 @Override
 public void showEnemy(String name, int currHp, int defense, ArrayList<EffectsInterface> effects,int paralysed) {
  System.out.println(name + " "+currHp);
  
 }
 
 
 @Override
 public void askAction() {
  System.out.println("Which you like to do:\nType: Magic|Attack");
  
 }
 
 @Override
 public void showMagic(ArrayList<MagicInterface> magicArray) {
 
  System.out.println("Available:\n");
  int count = 0;
  for (MagicInterface m : magicArray) {
   System.out.println(count + " " + magicArray.get(count).toString());
   System.out.println();
   count++;
  }
 }
 
 @Override
 public void askForMagic(ArrayList<MagicInterface> magicArray) {
   System.out.println("Type the number of Magic:");
   this.showMagic(magicArray);
  }
 
 
 @Override
 public void showCharacters(ArrayList<PlayerCharacter> characters) {
    System.out.println(characters);
  }
 
  @Override
 public void showEnemies(ArrayList<Enemy> enemies) {
 
   System.out.println("Enemies on fight:\n");
   int count = 0;
   for (Enemy e : enemies) {
    System.out.println(count + " " + enemies.get(count).toString());
    System.out.println();
    count++;
   }
  }
  
  @Override
 public void showInventary(Controller c) {
    System.out.println("Este es el inventario:\n");
    int count = 0;
    for (Weapon w : c.getInventary()) {
      System.out.println(count+" "+ c.getInventary().get(count).toString());
      System.out.println();
      count++;
    }
  }
  
  @Override
 public void askForInventaryWeapon(Controller c) {
    System.out.println("Type the number of the weapon:\n");
    this.showInventary(c);
   
  }
 
  @Override
 public void showInvalidWeaponAssignmentException(GameCharacter g, Weapon w) {
    System.out.println(g.getName() + " cannot use " + w.getName());
  }
 
 @Override
 public void showWeaponNotInInventaryException(Weapon w) {
  System.out.println(" Weapon :" + w.getName() +" not in Inventary");
 }
 
  @Override
 public void askForEnemy(ArrayList<Enemy> enemies)  {
  System.out.println("Type an Enemy Number:");
   this.showEnemies(enemies);
  }
 
 @Override
 public void showInvalidWeaponMsg() {
    System.out.println("Choose a Valid Weapon.");
  }
 
 @Override
 public void showInvalidEnemyMsg() {
    System.out.println("Choose a valid Enemy");
  }
 
  @Override
 public void showWeaponEquipment(GameCharacter g, Weapon w) {
    System.out.println(g.getName()+ " select "+w.getName());
  }
 
  @Override
 public void showAttack(GameCharacter g, GameCharacter r) {
    System.out.println(g.getName()+" attacks to "+r.getName());
  }
 
  @Override
 public void showCharactersWin() {
    System.out.println("Congrats You win !!");
  }
 
  @Override
 public void showEnemiesWin() {
  System.out.println("Enemies win, try again");
  }
 
 @Override
 public void showOptions() {
  System.out.println("Or Type:\n'Magic': to select Magic|'Enemy': to select a target|'Weapon': to equip weapon|" +
                             "'Magic' Attack: to use magic|'Attack': to attack");
 }
 
 @Override
 public void showInvalidMagicMsg() {
  System.out.println("Choose a Valid Magic");
  
 }
 
 @Override
 public void showNullWeaponExceptionMsg(GameCharacter activeCharacter) {
  System.out.println("%s (%s) does not have a weapon".formatted(activeCharacter.getName(),activeCharacter.getClass()));
  
 }
 
 @Override
 public void showMagicAttack(GameCharacter activeCharacter, GameCharacter target) {
 
 }
 
 @Override
 public void showNotEnoughMpExceptionMsg(GameCharacter activeCharacter) {
  System.out.println( "%s (%s) has not enough mp points: %d mp".formatted(activeCharacter.getName(),
          activeCharacter.getClass().getName(),((PlayerMage)activeCharacter).getcurrentMp()));
  
 }
 
 @Override
 public void showNotImplementsMagicExceptionMsg(GameCharacter activeCharacter) {
  System.out.println(" %s (%s) does not implements this magic".formatted(activeCharacter.getName(),
          activeCharacter.getClass().getName()));
  
 }
}

