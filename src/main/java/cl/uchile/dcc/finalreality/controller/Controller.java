package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.controller.States.StateInterface;
import cl.uchile.dcc.finalreality.controller.factories.*;
import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.TurnsQueue;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.magic.MagicInterface;
import cl.uchile.dcc.finalreality.model.weapon.*;
import cl.uchile.dcc.finalreality.view.ViewInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Controller which drives the logic of the game.
 */
public class Controller implements DeathObserverInterface {
  
  private Player player;
  private  GameCharacter activeCharacter;
  private  Weapon selectedWeapon;
  private  GameCharacter target;
  
  private static Controller uniqueInstance;
  
  private ViewInterface view;
  private  ArrayList<PlayerCharacter> characters;
  private  ArrayList<Enemy> enemies;
  
  private  ArrayList<Weapon> inventary;
  
  private String userInput="";
  
  private static TurnsQueue queue;
  public static  int  maxCharacters = 5;
  private static  int  maxEnemies = 5;
  private static  int  maxWeapon = 5;
  private IFactory factory;
  
  private MagicInterface magic;
  
  private StateInterface state;
  
  Random random = new Random();
  
  
  public  Controller() {
    this.characters = new ArrayList<>();
    this.enemies = new ArrayList<>();
    this.inventary = new ArrayList<>();
    this.queue = new TurnsQueue();
    this.setMaxCharacters(5);
  }
  
  public  static Controller getUniqueInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new Controller();
    }
    return uniqueInstance;
  }
  public void setSeed(int x){
    this.random= new Random(x);
  }
  
  public void setUserInput(String userInput) {
    this.userInput=userInput;
  }
  public String getUserInput() {
    return this.userInput;
  }
  
  public Player getPlayer() {
    return this.player;
  }
  
  public void setPlayer(Player player) {
    this.player = player;
  }
  
  public void setState( StateInterface state) {
    this.state = state;
  }
  
  public StateInterface getState() {
    return this.state;
  }
  public ViewInterface getView() {
    return view;
  }
  public void setView(ViewInterface view) {
    this.view=view;
  }
  
  public GameCharacter getActiveCharacter() {
    return  this.activeCharacter;
  }
  
  public void setActiveCharacter(GameCharacter g) {
    this.activeCharacter = g;
  }
  
  public GameCharacter getTarget() {
    return  this.target;
  }
  
  public void setTarget(GameCharacter g) {
    this.target = g;
  }
  
  public Weapon getSelectedWeapon() {
    return  this.selectedWeapon;
  }
  
  public void setSelectedWeapon(Weapon w) {
    this.selectedWeapon = w;
  }
  
  /**
   * A getter for the controller's factory.
   */
  
  public IFactory getFactory() {
    return this.factory;
  }
  
  /**
   * A getter for the controller's factory.
   */
  
  public void setFactory(IFactory factory) {
    this.factory=factory;
  }
  /**
   * A getter for the controller's queue.
   */
  
  public TurnsQueue getQueue() {
    return this.queue;
  }
  
  /**
   * A getter for the controller's characters Array.
   */
  public ArrayList<PlayerCharacter> getCharacters() {
    return this.characters;
  }
  /**
   * A getter for the controller's characters Array.
   */
  
  public ArrayList<Enemy> getEnemies() {
    return this.enemies;
  }
  
  /**
   * A setter for the maximum numbers of characters.
   */
  
  public void setMaxCharacters(int max) {
    this.maxCharacters = max;
  }
  
  /**
   * A method that checks if the number of character is equal to  the max number.
   */
  
  public boolean isMaxCharacters() {
    return this.maxCharacters == this.getCharacters().size();
  
  }
  
  /**
   * A method that checks if the number of character is equal to  the max number.
   */
  
  public boolean isMaxEnemies() {
    return this.maxEnemies == this.getEnemies().size();
  }
  
  /**
   *This method creates a new character instance and append it  to the character's Array.
   */
  
  public PlayerCharacter createCharacter() {
    PlayerCharacter p =(PlayerCharacter) this.factory.create(this.getQueue());
    p.setController(this);
    this.characters.add(p);
    return p;
  }
  
  /**
   *This method creates a new Enemy instance and append it  to the Enemies Array.
   */
  public Enemy createRandomEnemy() {
    Random random = this.random;
    int p = random.nextInt(30, 120);
    setFactory(new EnemyFactory());
    this.factory.setDefense(p/3);
    this.factory.setMaxHp(p);
    ((EnemyFactory) this.factory).setWeight(p);
    ((EnemyFactory) this.factory).setAttack(p - 20);
    
    int i = this.enemies.size();
    this.factory.setName("enemy" + i);
    Enemy e= (Enemy) factory.create(this.getQueue());
    e.setController(this);
    enemies.add(e);
    return e;
    
  }
  
  /**
   *(Adapter) Method to simulate an attack between two GameCharacters, an attacker  and  target .
   */
  public void attack(GameCharacter c1, GameCharacter c2) {
    c1.attack(c2);
  }
  
  /**
   *Method to select a Magic attack and set it into controller.
   */
  
  public void selectMagic(MagicInterface magic) {
    this.magic = magic;
  }
  
  /**
   *Method to get a Magic attack and set it into controller.
   */
  
  public MagicInterface getMagic() {
    return this.magic;
  }
  
  
  /**
   *Method to simulate a  magic attack  from a Mage to a Game Character.
   */
  
  public void useMagic(GameCharacter m, GameCharacter c) throws NotImplementsMagicException, NotEnughMpException {
      m.implementsMagic(this.magic,c);
  }
  
  
  /**
   *Method to simulate a  magic attack  from a Mage to a Game Character.
   */
  
  public void sendToQueue(GameCharacter g) throws NullWeaponException {
    g.waitTurn();
  }
  
  @Override
  public void updateDeaths(GameCharacter character) {
    if (character.getCurrentHp() == 0) {
      character.dead();
    }
  }
  
  public boolean doesPlayerWin() {
    return (this.enemies.isEmpty());
  }
  
  
  public boolean doesEnemiesWin() {
    return (this.characters.isEmpty());
  }
  
  public void setInventary (ArrayList<Weapon> inventary) {
    this.inventary =inventary;
  }
  
  public ArrayList<Weapon> getInventary() {
    return this.inventary ;
  }
  
  public void defaultInventary() {
    ArrayList<Weapon> inventary= new ArrayList<Weapon>();
    inventary.add(new Axe("axe",80,50));
    inventary.add(new Bow("bow",30,20));
    inventary.add(new Knife("knife",50,30));
    inventary.add( new Staff("staff",20,80,80));
    inventary.add( new Sword("sword",100,90));
   this.setInventary(inventary);
  }
  public void defaultCharacterSelection(){
    this.setFactory(new EngineerFactory());
    this.createCharacter();
    
    this.setFactory(new KnightFactory());
    this.createCharacter();
    
    this.setFactory(new ThiefFactory());
    this.createCharacter();
    
    this.setFactory(new WhiteMageFactory());
    this.createCharacter();
    
    this.setFactory(new BlackMageFactory());
    this.createCharacter();
  }
  public void defaultWpnAssignment() throws InvalidWeaponAssignmentException, WeaponNotInInventoryException {
    
    ArrayList<Weapon> I=this.getInventary();
    ArrayList <PlayerCharacter>C=this.getCharacters();
    this.equipFromInvetory(C.get(0),I.get(0));
    this.equipFromInvetory(C.get(1),I.get(4));
    this.equipFromInvetory(C.get(2),I.get(1));
    this.equipFromInvetory(C.get(3),I.get(3));
    this.equipFromInvetory(C.get(4),I.get(2));
    
  }
  public void equipFromInvetory(PlayerCharacter p, Weapon w) throws WeaponNotInInventoryException, InvalidWeaponAssignmentException {
    if (inventary.contains(w)) {
        p.equip(w);
    } else {
      throw new WeaponNotInInventoryException();
    }
  }
  
  public boolean isMaxWeapon(){
    return this.getInventary().size()==this.maxWeapon;
  }
  public int countEquippedCharacter(){
    int count=0;
    for (PlayerCharacter p: this.getCharacters()){
      if (p.getEquippedWeapon()!=null){count++;}
    }
    return count;
  }
  
}

