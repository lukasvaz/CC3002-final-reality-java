package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.controller.Player;
import cl.uchile.dcc.finalreality.controller.factories.KnightFactory;
import cl.uchile.dcc.finalreality.controller.factories.ThiefFactory;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.view.NullView;
import cl.uchile.dcc.finalreality.view.PrimitiveView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SelectWeaponTest {
 
 StateInterface selectWeapon;
 Controller c;
 
 @BeforeEach
 void setUp(){
  c = new Controller();
  selectWeapon= new SelectWeapon();
 }
 
 @Test
 void action() throws InvalidWeaponAssignmentException, IOException, NullWeaponException, WeaponNotInInventoryException {
  c.setState(selectWeapon);
  c.setView(new PrimitiveView());
  c.defaultInventary();
  c.setFactory(new ThiefFactory());
  PlayerCharacter t = c.createCharacter();
  c.setActiveCharacter(t);
  //select weapon then attacks
  c.setPlayer(new Player("0\n1\nAttack"));
  c.getState().action(c);
  assertEquals(c.getInventary().get(1),c.getSelectedWeapon());
  assertEquals(c.getInventary().get(1),((PlayerCharacter)c.getActiveCharacter()).getEquippedWeapon());
  assertEquals(Attack.class,c.getState().getClass());
  //select weapon then goes to selectMagic
  c.setState(selectWeapon);
  c.setPlayer(new Player("2\n0\nMagic"));
  c.getState().action(c);
  assertEquals(c.getInventary().get(0),c.getSelectedWeapon());
    //invalid assignment Axe (0), should preserve last weapon Bow(2)
  assertEquals(c.getInventary().get(2),((PlayerCharacter)c.getActiveCharacter()).getEquippedWeapon());
  assertEquals(SelectMagic.class,c.getState().getClass());
  //select weapon then selectEnemies
  c.setState(selectWeapon);
  c.setPlayer(new Player("1\n0\n3\nEnemy"));
  c.getState().action(c);
  assertEquals(c.getInventary().get(3),c.getSelectedWeapon());
  assertEquals(c.getInventary().get(1),((PlayerCharacter)c.getActiveCharacter()).getEquippedWeapon());
  assertEquals(selectEnemy.class,c.getState().getClass());
  //wrong input do nothing then  change to MagicAttack
  c.setState(selectWeapon);
  c.setFactory(new KnightFactory());
  PlayerCharacter k = c.createCharacter();
  c.setActiveCharacter(k);
  c.setPlayer(new Player("4\nhola\nMagicAttack"));
  c.getState().action(c);
  assertEquals(c.getInventary().get(4),c.getSelectedWeapon());
  assertEquals(c.getInventary().get(4),((PlayerCharacter)c.getActiveCharacter()).getEquippedWeapon());
  assertEquals(MagicAttack.class,c.getState().getClass());
  
 }
 
 @Test
 void updateState() {
  c.setState(selectWeapon);
  c.setUserInput("Weapon");
  c.getState().updateState(c);
  assertEquals(SelectWeapon.class,c.getState().getClass());
 }
 @Test
 void selectMagic() {
  c.setState(selectWeapon);
  c.getState().selectMagic(c);
  assertEquals(SelectMagic.class,c.getState().getClass());
 }
 @Test
 void selectEnemy() {
  c.setState(selectWeapon);
  c.getState().selectEnemy(c);
  assertEquals(selectEnemy.class,c.getState().getClass());
 }
 @Test
 void Attack() {
  c.setState(selectWeapon);
  c.getState().Attack(c);
  assertEquals(Attack.class,c.getState().getClass());
 }
 @Test
 void MagicAttack() {
  c.setState(selectWeapon);
  c.getState().magicAttack(c);
  assertEquals(MagicAttack.class,c.getState().getClass());
 }
}