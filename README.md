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
<li> A new <em>Abstract Class </em>  called <b><em>AbstractMage</em></b>  class was added to group the behaviour of 
<em>WhiteMages</em> and  <em>BlackMages</em>. Now the proyect is <b>open</b>
to get new features of <em>Mages</em>.The proyect has also been given with the interface <em>Mage</em> (extending 
of <em>Playercharacter</em> ) wich guaranted that some methods related to <em>Mages</em> must be implemented in the 
<em>AbstractMage</em> class.</li>

<li> <em>waitTurn()</em> was impemented for each <em>Enemy</em> and  <em>AbstractPlayerCharacter</em> 
 classes.The purpouse of this is following the encapsulation principle where each class handles its funcionalities. </li>

<li><em>Enemy</em> was given  with the  method  <em>toString</em>, now it can be compared consistently with 
the other classes</li>

<li></li>
</ol>

