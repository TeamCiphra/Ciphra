# Ciphra

##Members
Jonathan Luu
Jonathan Yen

#Overhaul
##Global Changes
Kick Adam/Chris
Rework gameStats to make the variables globally similar.
###Main
Most code has been moved out and place in correct classes.  The battle elements have been moved to a new class called 'Battle'.
##Battle
*New Class*
The location of the code from 'Main'.  Includes all buttons, gridpanes, stackpanes, labels, etc. relating to battle.
##Attack
*New Class*
Basically the stuff that Adam/Chris took too long on done in one day and place in a new class.  This class is where damage is calculated and outputted.  
Energy has no used at the current moment but will be implemented at a later date.  Also w/in 'Attack', there is ATT/DEF Multiples w/ will be dodge and 
crit.  Basically the player's or enemy's is multiplied to a the ATT Multiple which ranges from 0.8 to 1.2.  This number is then divided but the DEF Multiple
which also ranges from 0.8 to 1.2.  These numbers may or may not change based on the fact that crits do more than 120% damage.  Possible a 0.9 to 1.5?  Also
DEF seems a bit op with 0.8 increaing the damage.  May change to 1 to 1.5 to have you defend or not.
##Itembag
Nothing major just the global gameStats fix.
##Loader
Splitting up the Loader.  Now to functions (ImageLoader & PlayerLoader).  While both are still images, the breakup (more will be added later), will allow us to
easily manage the items within 'Loader'.

#Week Plan
Sprite recreation.  Added new sprite for HP Pot.  Enemy gifs will be ?removed? and replace with something more size appropriate.  Will also start working on ?animations?
Also IDK how to get back to 'Main' from run away in 'Battle'.  This will be worked on but I'm thinking that we might have the battle open in a new window like items do.
Remap the gridpane and how the button, lables, health bars, and sprites fit onto the window.  More like PKM battles, Fire Emblem, or creating something oursleves.

