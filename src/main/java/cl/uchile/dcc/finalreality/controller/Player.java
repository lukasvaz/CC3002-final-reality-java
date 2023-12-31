package cl.uchile.dcc.finalreality.controller;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponAssignmentException;
import cl.uchile.dcc.finalreality.exceptions.WeaponNotInInventoryException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Player {
 
 private final BufferedReader in;
 
 public Player(BufferedReader initIn) {
  in = initIn;
 }
 
 /**
  * The normal contructor to use:
  */
 public Player() {
  this( new BufferedReader(new InputStreamReader(System.in)));
 }
 
 
 /**
  * Special constructor to make a tictactoe.Player that plays a fixed
  * set of moves from a String.  Used to define test cases.
  */
 
  public Player( String moves) {
  this( new BufferedReader(new StringReader(moves)));
 }
 
 
  public void selectWeaponMove(Controller c) throws IOException, InvalidWeaponAssignmentException, WeaponNotInInventoryException {
  String line;
  line = in.readLine();
  c.getState().selectWeaponMove(line ,c);
  }
 
 public void move(Controller c) throws IOException {
   try {
    String line;
    line = in.readLine();
    c.setUserInput(line);
   }
   catch (NullPointerException n){
    System.out.println("Null Input");
   }
 }
 }
 

