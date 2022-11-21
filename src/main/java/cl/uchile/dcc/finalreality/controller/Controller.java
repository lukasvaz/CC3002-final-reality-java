package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.ArrayList;

/**
 * Controller which drives the logic of the game.
 */
public class Controller {
 
  /**
  * Set the initial conditions of the game.
  */
  public static void main(String[] args) {
   
    TurnsQueue queue = new TurnsQueue();
    ArrayList<Weapon> inventario = new ArrayList<>() {
      {
        add(new Axe("Axe", 5, 3));
        add(new Sword("sword", 5, 3));
      }
    };
    ArrayList<PlayerCharacter> characters = new ArrayList<>() {
      {
        add(new Knight("knight", 100, 20, queue));
        add(new Engineer("eng1", 5, 3, queue));
      }
    };
    ArrayList<Enemy> enemyparty = new ArrayList<>() {
      {
        add(new Enemy("enemy1", 30, 30, 45, queue));
        add(new Enemy("enemy2", 50, 30, 45, queue));
      }
    };
    EnemyParty enemies = new EnemyParty(enemyparty);
    Player player = new Player(inventario, characters);
    Game game = new Game(player,enemies);
    play(game);
  }
  /**
  * start playing.
  */
  
  public static void play(Game game) {
    System.out.println("New Player");
    System.out.println(game.player.toString());
    System.out.println("New Enemies");
    System.out.println(game.enemies.toString());
    do {
      System.out.println(game.player.toString());
    } while (false);
  }
}
