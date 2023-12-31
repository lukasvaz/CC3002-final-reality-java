package cl.uchile.dcc.finalreality.controller.States;

import cl.uchile.dcc.finalreality.controller.Controller;
import cl.uchile.dcc.finalreality.exceptions.NotEnughMpException;
import cl.uchile.dcc.finalreality.exceptions.NotImplementsMagicException;
import cl.uchile.dcc.finalreality.exceptions.NullWeaponException;

public class MagicAttack extends AbstractState{
 
 @Override
 public void action(Controller c) throws NullWeaponException {
  try {
   c.useMagic(c.getActiveCharacter(),c.getTarget());
   c.getView().showMagicAttack(c.getActiveCharacter(), c.getTarget());
   c.getTarget().notifyDmg();
   c.getTarget().show();
   if (c.doesPlayerWin()) {
    c.getState().end(c);
   } else {
    c.sendToQueue(c.getActiveCharacter());
    c.getState().initTurn(c);}
  } catch (NotEnughMpException m) {
   c.getView().showNotEnoughMpExceptionMsg(c.getActiveCharacter());
   c.getState().selectEnemy(c);
  }catch (NotImplementsMagicException e) {
   c.getView().showNotImplementsMagicExceptionMsg(c.getActiveCharacter());
   c.getState().selectEnemy(c);
  }catch (NullWeaponException e) {
   c.getView().showNullWeaponExceptionMsg(c.getActiveCharacter());
   c.getState().selectEnemy(c);
  }
 }
 
 
 public void updateState(Controller c) {
  if(c.getUserInput().equals("MagicAttack")){
   c.getState().magicAttack(c);
  }
 }
 public void initTurn(Controller c) {
  c.setState(new initTurn());
 }
 
 public void selectEnemy(Controller c) {
  c.setState(new selectEnemy());
 }
 
 public void end(Controller c) {
  c.setState(new End());
 }
 
}
