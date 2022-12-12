package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

import java.io.IOException;

public class CharacterTurn extends  AbstractState {
 @Override
 public void action(Controller c) throws IOException {
  
  //weapon assignment
  while(((PlayerCharacter)c.getActiveCharacter()).getEquippedWeapon() == null) {
      c.getView().askForInventaryWeapon(c);
      c.getPlayer().move(c);
      while (!c.getUserInput().equals("ok")) {
        c.setSelectedWeapon(c.getInventary().get(Integer.parseInt(c.getUserInput())));
        c.getView().showWeaponEquipment(c.getActiveCharacter() ,c.getSelectedWeapon());
        c.getView().askForInventaryWeapon(c);
        c.getPlayer().move(c);
      }
      
      
      try {
        c.equipFromInvetory((PlayerCharacter)c.getActiveCharacter(),c.getSelectedWeapon());
        c.getView().showWeaponEquipment(c.getActiveCharacter(),c.getSelectedWeapon());
      } catch (InvalidWeaponAssignmentException i) {
        c.getView().showInvalidWeaponAssignmentException(c.getActiveCharacter(),c.getSelectedWeapon());
      } catch (WeaponNotInInventoryException w) {
        c.getView().showWeaponNotInInventaryException(c.getSelectedWeapon());
      }
    }
    //target assignment
    while (c.getTarget() == null) {
      try {
        c.getView().askForEnemy(c.getEnemies());
        c.getPlayer().move(c);
        c.setTarget(c.getEnemies().get(Integer.parseInt(c.getUserInput())));
        
      } catch (IndexOutOfBoundsException i) {
        c.getView().showInvalidEnemyMsg();
      }
    }
    //attack
    c.attack(c.getActiveCharacter(),c.getTarget());
    c.getView().showAttack(c.getActiveCharacter(),c.getTarget());
    c.getTarget().notifyDmg();
    
    c.getView().showEnemy(c.getTarget().getName(),c.getTarget().getCurrentHp(),c.getTarget().getDefense(),
            ((Enemy)c.getTarget()).getEffects(),((Enemy)c.getTarget()).getParalyseCounter());
    c.setSelectedWeapon(null);
    c.setActiveCharacter(null);
    c.setUserInput("");
    
    //change state
    if (c.doesPlayerWin()) {
      c.getState().end(c);
    } else {
      c.getState().initTurn(c);
    }
  }
  
  public void end(Controller c) {
    c.setState( new End());
  }
  
  public void initTurn(Controller c) {
    c.setState( new initTurn());
  }
  
 
}