package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import java.util.ArrayList;

/**
 * Game class which determines the rules of the game.
 */

public class EnemyParty {
  int maxEnemies;
  ArrayList<Enemy> enemies;
  
  public EnemyParty(ArrayList<Enemy> enemies) {
    this.enemies = enemies;
  }
  
  @Override
  public String toString() {
    String enemiestostr="";
    for (Enemy i: enemies) {
      enemiestostr += i.toString()+"\n";
    }
    return "Enemies:\n"+enemiestostr;
  }
}
