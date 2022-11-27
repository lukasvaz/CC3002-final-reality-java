package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.model.character.EnemyParty;
import cl.uchile.dcc.finalreality.model.character.player.Player;

/**
 * Game class which determines the rules of the game.
 */

public class Game {
  boolean notOver;
  Player player;
  EnemyParty enemies;
  /**
  * Constructor Initialize a game.
  */
  
  public Game(Player player, EnemyParty enemies) {
    this.enemies = enemies;
    this.player = player;
    this.notOver = false;
  }
}
