package cl.uchile.dcc.finalreality.controller.States;


import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

public class SelectCharacter extends AbstractState {
 
 
 public void action(Controller controller)  {
  
    while(!controller.isMaxCharacters()) {
      //add characters
      controller.getView().askForCharacter();
      controller.defaultCharacterSelection();
    }
    controller.getView().showCharacters(controller.getCharacters());
    while (!controller.isMaxWeapon()) {
      //add Weapons
      controller.defaultInventary();
    }
    controller.getView().showInventary(controller);
   
    while (controller.countEquippedCharacter() != controller.getCharacters().size()) {
      try {
        controller.defaultWpnAssignment();
      } catch (InvalidWeaponAssignmentException i) {
        System.out.println("Asignación invalida");
        continue;
       } catch(WeaponNotInInventoryException n) {
        System.out.println("Arma no esta en el inventorio");
        continue;
      }
    }
   
    if (controller.isMaxCharacters() && controller.isMaxWeapon()) {
      this.createEnemy(controller);
    }
  }
  
  public  void createEnemy(Controller controller) {
   controller.setState( new createEnemy() );
  }
 
}
