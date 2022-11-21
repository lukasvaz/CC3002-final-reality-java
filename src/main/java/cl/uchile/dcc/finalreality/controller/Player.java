package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.*;
import java.util.ArrayList;

/**
 * Class for player instance.
 */
public class Player {
  int maxCharacters;
  int numberCharacters;
  ArrayList<Weapon> inventario;
  ArrayList<PlayerCharacter> party;
 
 
  public  Player(ArrayList<Weapon> inventario, ArrayList<PlayerCharacter> party) {
    this.inventario = inventario;
    this.party = party;
  }
 
  @Override
  public String toString() {
    String inventarystr = "";
    String partystr = "";
    for (Weapon i : this.inventario) {
      inventarystr += i.toString() + "\n";
    }
   
    for (PlayerCharacter i : this.party) {
      partystr += i.toString() + "\n";
    }
    return ("Player inventary:\n" + inventarystr + "Player characters:\n" + partystr);
 }
}
