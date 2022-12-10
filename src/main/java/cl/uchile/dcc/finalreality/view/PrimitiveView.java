package cl.uchile.dcc.finalreality.view;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.factories.IFactory;
import cl.uchile.dcc.finalreality.controller.factories.KnightFactory;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimitiveView implements ViewInterface{
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
  System.out.println( "Turn of :\n"+g);
  
 
 }
 
 @Override
 public void showAttack() {
 
 }
 
 @Override
 public void askAction() {
 
 }
 
 @Override
 public void showMagicOptions() {
 
 }
 
 @Override
 public void showCharacters(Controller c) {
  System.out.println(c.getCharacters());
 }
 
 @Override
 public void showEnemies(Controller c) {
  System.out.println(c.getEnemies() +"\n");
 }
 
 @Override
 public void showInventary(Controller c) {
  System.out.println("Este es el inventario:\n");
  int count=0;
  for(Weapon w: c.getInventary()){
   System.out.println(count +c.getInventary().get(count).toString());
   System.out.println();
   count++;
  }
 }
 
 @Override
 public Weapon askForInventaryWeapon(Controller c) {
  System.out.println("Type the number of the weapon:\n");
  this.showInventary(c);
  Scanner sc = new Scanner(System.in); //System.in is a standard input stream
  int n = sc.nextInt();
  return c.getInventary().get(n);
 }
}
