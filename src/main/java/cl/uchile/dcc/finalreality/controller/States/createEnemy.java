package cl.uchile.dcc.finalreality.controller.States;


import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

public class createEnemy extends AbstractState {
 
 @Override
 public void action(Controller controller) throws NullWeaponException {
    
    while (!controller.isMaxEnemies()) {
      controller.createRandomEnemy();
    }
    controller.getView().showEnemies(controller.getEnemies());
    controller.getView().showLoading();
    
    for (Enemy e : controller.getEnemies()) {
      controller.sendToQueue(e);
    }
    for (PlayerCharacter p : controller.getCharacters()) {
      controller.sendToQueue(p);
    }
    this.initTurn(controller);
  }
  
 
  @Override
 public void initTurn(Controller controller) {
    controller.setState( new initTurn());
  }
}
