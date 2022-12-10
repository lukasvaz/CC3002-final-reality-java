package cl.uchile.dcc.finalreality.exceptions;

public class WeaponNotInInventoryException extends Exception{
 
 public WeaponNotInInventoryException() {
  super("This Weapon Is not in Inventory.");
 }
}

