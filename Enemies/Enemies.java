/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Common interface used to define methods to be used by all enemies faced by the character
* Project: Turn Based Combat Game
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/
package Enemies;
public interface Enemies 
{
    public String getName(); //Retrieve the name of an enemy
    public void setHealth(int health); //Set the health of an enemy
    public int getMaxHealth(); //Retrieve the maximum health of an enemy. Different enemies have different values for maximum health
    public int getCurrHealth(); //Retrieve current health of enemy
    public int getMinDamage(); //Retrieve minumum damage enemy can cause
    public int getMaxDamage(); //Retrieve maximum damage enemy can cause
    public int getDamage(); //Retrieve damage an enemy causes when it attacks
    public int getDefence(); //Retrieve defence used by enemy when being attacked
    public int goldAward(); //Retrieve gold awarded to player when they defeat the enemy
    public int getSpecialAbilities(); //Retrieve the special abilities of an enemy   
}