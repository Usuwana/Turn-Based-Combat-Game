/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Meant to set, modify and contain information about the enemy Ogre
* Project: Turn Based Combat Game
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/
package Enemies;
//Implements enemies interface
public class Ogre implements Enemies 
{
    private String name = "Ogre";
    private int health = 40;
    private int minimum = 5;
    private int maximum = 10;

    //Retrieve name of Ogre
    @Override
    public String getName() 
    {
        return name;
    }

    //Set the health of Ogre to any number that does not surpass the maximum allowed
    @Override
    public void setHealth(int health)
    {
        if (health <= getMaxHealth())
        {
            this.health = health;
        }
        else
        {
            System.out.println("Health cannot surpass " + getMaxHealth());
        }
    }

    //Retrieves the maximum health number allowed
    @Override
    public int getMaxHealth() 
    {
        return 40;
    }

    //Retrieves the current health of the ogre
    @Override
    public int getCurrHealth() 
    {
        return health;
    }

    //Retrieves the minimum damage the ogre can cause
    @Override
    public int getMinDamage()
    {
        return minimum;
    }

    //Retrieves the maximum damage the ogre can cause
    @Override
    public int getMaxDamage()
    {
        return maximum;
    }

    //Retrieves the overall damage the ogre can cause. The value is a number between the minimum and maximum damages
    @Override
    public int getDamage() 
    {
        int difference = maximum - minimum;
        int effect = (int) (Math.random() * (difference + 1) + minimum);
        int damage = effect;
        return damage;
    }

    //Retrieves the defence the ogre can give. The value is a number between the initialized minimum and maximum values
    @Override
    public int getDefence() 
    {
        int minimum = 6;
        int maximum = 12;
        int difference = maximum - minimum;
        int damage = (int) (Math.random() * (difference + 1) + minimum);
        return damage;
    }

    //Retrieves gold to be given to player after defeating ogre
    @Override
    public int goldAward() 
    {
        return 40;
    }

    //Retrieves special abilities to be added to the ogre based on a 20% probability
    @Override
    public int getSpecialAbilities()
    {
        int damage = 0;
        double probability = Math.random();
        if (probability < 0.2)
        {
            damage = getDamage() + getDamage();
        }

        return damage;
    }
    
}