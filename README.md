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

---
Changes
-------
Some features have been modified to guarante a proper design of the software.Here is  a quick summary of the main 
changes: 
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

