package cl.uchile.dcc.finalreality.view;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.factories.*;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.effects.EffectsInterface;
import cl.uchile.dcc.finalreality.model.magic.MagicInterface;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class which manages the interaction with user.
 */

public class NullView implements ViewInterface {
 
 @Override
 public IFactory askForCharacter() {
  return null;
 }
 
 @Override
 public void showLoading() {
 
 }
 
 @Override
 public void showTurn(GameCharacter g) {
 
 }
 
 @Override
 public void showCharacter(String name, int currHp, int defense, Weapon weapon) {
 
 }
 
 @Override
 public void showEnemy(String name, int currHp, int defense, ArrayList<EffectsInterface> effects, int paralysed) {
 
 }
 
 @Override
 public void askAction() {
 
 }
 
 @Override
 public void showMagic(ArrayList<MagicInterface> magicArray) {
 
 }
 
 @Override
 public void askForMagic(ArrayList<MagicInterface> magicArray) {
 
 }
 
 
 
 @Override
 public void showCharacters(ArrayList<PlayerCharacter> characters) {
 
 }
 
 @Override
 public void showEnemies(ArrayList<Enemy> enemies) {
 
 }
 
 @Override
 public void showInventary(Controller c) {
 
 }
 
 @Override
 public void askForInventaryWeapon(Controller c) {
 
 }
 
 @Override
 public void showInvalidWeaponAssignmentException(GameCharacter g, Weapon w) {
 
 }
 
 @Override
 public void showWeaponNotInInventaryException(Weapon w) {
 
 }
 
 @Override
 public void askForEnemy(ArrayList<Enemy> enemies) {
 
 }
 
 @Override
 public void showInvalidWeaponMsg() {
 
 }
 
 @Override
 public void showInvalidEnemyMsg() {
 
 }
 
 @Override
 public void showWeaponEquipment(GameCharacter g, Weapon w) {
 
 }
 
 @Override
 public void showAttack(GameCharacter g, GameCharacter r) {
 
 }
 
 @Override
 public void showCharactersWin() {
 
 }
 
 @Override
 public void showEnemiesWin() {
 
 }
 
 @Override
 public void showOptions() {
 
 }
 
 @Override
 public void showInvalidMagicMsg() {
 
 }
 
 @Override
 public void showNullWeaponExceptionMsg(GameCharacter activeCharacter) {
 
 }
 
 @Override
 public void showMagicAttack(GameCharacter activeCharacter, GameCharacter target) {
 
 }
 
 @Override
 public void showNotEnoughMpExceptionMsg(GameCharacter activeCharacter) {
 
 }
 
 @Override
 public void showNotImplementsMagicExceptionMsg(GameCharacter activeCharacter) {
 
 }
}
