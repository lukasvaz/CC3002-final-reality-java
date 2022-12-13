Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

------

Run Instructions
-------

This project has two testing files:<em>TimerExample.java</em> and  <em>Main.java</em>.TimerExample will test the 
functionality of the turn system, crating an instance of each class and printing them in the right order.Main.java will 
test the functionality of  every method of each class (i.e. getters ,setters,to string etc).Run both files for testing. 


------
Changes
-------
Some features have been modified to guarante a proper design of the software.Here is  a quick summary of the main 
changes: 

<b>T1</b>
<ol>
<li> A new <em>Abstract Class </em>  called <b><em>AbstractMage</em></b>  class was added to implement the behaviours of 
<em>WhiteMages</em> and  <em>BlackMages</em>. Now the proyect is <b>open</b>
to get new features of <em>Mages</em>.The proyect also got the interface <b><em>PlayerMage</em></b> (extending 
of <em>Playercharacter</em> ) wich guarantees that  methods related to <em>Mages</em> must be implemented in the 
<em>AbstractMage</em> class.</li>
<br>
<li> <b><em>waitTurn()</em></b> was impemented for each <em>Enemy</em> and  <em>AbstractPlayerCharacter</em> 
 classes.The purpouse of this is follow the encapsulation principle where each class handles its funcionalities acording to their weights 
or Weapon´s weights. </li>
<br>
<li> A new class  <b><em>TurnsQueue</em></b> was added following the "single responsability" principle , this class will 
handle the functionalities related to the turns.</li><br>
<li><em>Enemy</em> got  the  method  <b><em>toString</em></b>, now it can be compared consistently with 
the other classes</li>
</ol>

<b>T2</b>
<ol>
<li>A new weapon interface was added,which is implemented by each weapon classes.</li>
<li>Tests were implemented.It was added a unit test for each  player class  and weapon class.</li>

<li> New exceptions were added. <em>NullWeaponException</em> to guarantee the assignment of a weapon to a character
 before it get push to the queue.And also <em>InvalidWeaponAssignentException</em> which throws an error if
the assignment doesn't follow the weapon´s assignment conditions.</li>

<li>Weapon assignment restrictions were implemented.To do this the
<em>Weapon</em> interface got the method <em>equipedby()</em> and  <em>PlayerCharacter</em> 
interface got the methods <em>equipSword()</em>,<em>equipAxe()</em> 
,<em>equipKnife()</em>, <em>equipStaff()</em> and equipBow()</em>.<br>
Following the double dispatch design pattern,the method <em>equip()</em> in <em>AbstractPlayerCharacter</em> calls the method <em>equipedby()</em>
in <em>Weapon</em> (first dispatch) in order to disambiguate the weapon.Then the method 
<em>equippedby()</em> calls the respective method to equip the weapon in the 
differents characters classes (double dispatch).</li>
</ol>

<b>T3</b>
<ol>
<li>A new set of factories were implemented in order to instanciate characters and unified their
stats</li>
<li>It as implemented 2 methods to get attack's points , getAttack which  returns the  Dmg of
weapon assigned  to the character and getMagicAttack which return the magicDmg of the weapon (just
for Staff cases) or the Dmgs points of the weapon ( in this case returns Dmg/2), if the character corresponds
an Enemy getAttack() and getMagicAttack() returns Dmg</li>
<li>In order to implement the Effects associated to Magic attacks. Enemies were given 
of notifyEffects() method which send a meessage to every Effect Class.</li>
<li> Every time a character gets damaged  the character notifies (notifyDmg()) the controller, to check if its dead. If the 
character currentHp is equal to zero, the controller extracts the chracter from the queue and Arrays.</li>

<li>Every step of the game was implemented following the State Design Pattern.When the  game is setted up
the user have to choose characters and their inventary(selectCharacters), then Enemies are created
(createEnemy).Both of this States in this Primitive version of the Game were given of defaults
behaviours.Then a Character is pull from the queue at the begining of the turn (init Turn).When 
a character is  selected states goes to EnemyTurn (if it's an Enemy) or selectEnemy(if it's not an Enemy
, i this state the Palyer should select an Enemy target to Attack).In enemyTurn the Active Enemy updates its effects
 select a random character from the Characters array  and attack it.If there are not any remain character
 goes to End state.In other way,inside the selectEnemy State (character playing) the character is free to move using inputs
to selectWeapon (equips a Weapon) select Magic (select a Megic to Use) or back to select an Enemy target.The purpose of this
design is to simulate a Graphic Interface, where buttons are pressed in Asynchronus way.If the character wants to attack 
or use Magic, the user have to input "MagicAttack" or "Attack" from every state ( error handling takes care of 
the anomalous behaviours).To make the decissions according the user inputs, it was implemented a Input ListenerClass (
acts as an observer) which updates the Game State.
<li>To simulate inputs from the command line it was implemented a PlayerClass which can behave as a Scripted player.</li>
</ol>