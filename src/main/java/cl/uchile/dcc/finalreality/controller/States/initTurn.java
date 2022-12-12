package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
public class initTurn extends AbstractState {
  @Override
 public void action(Controller c) {
    GameCharacter g = c.getQueue().get_queue().poll();
    c.setActiveCharacter(g);
    c.getView().showTurn(g);
    g.selectTurn();
  }

  public  void enemyTurn(Controller controller) {
    controller.setState(new EnemyTurn());
  }
 
  public  void characterTurn(Controller controller) {
    controller.setState(new CharacterTurn());
  }
 
 public  void magicCharacterTurn(Controller controller) {
  controller.setState(new MagicCharacterTurn());
 }
 
 
}
