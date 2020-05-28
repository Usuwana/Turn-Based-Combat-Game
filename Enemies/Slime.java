/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Meant to set, modify and contain information about the enemy Slime
* Project: Turn Based Combat Game 
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/
package Enemies;
//Implements Enemies interface
public class Slime implements Enemies 
{
    private final String name = "Slime";
    private int health = 10;
    private int minimum = 3;
    private int maximum = 5;

    //Retrieve name of Slime enemy
    @Override
    public String getName() 
    {
        return name;
    }

    //Set health of Slime to any value that does not surpass the maximum health
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

    //Retrieves the maximum health of Slime
    @Override
    public int getMaxHealth() 
    {
        return 10;
    }

    //Retrieves curretn health of Slime
    @Override
    public int getCurrHealth() 
    {
        return health;
    }

    //Retrieves the minimum damage that Slime can cause
    @Override
    public int getMinDamage()
    {
        return minimum;
    }

    //Retrieves the maximum damage that Slime can cause
    @Override
    public int getMaxDamage()
    {
        return maximum;
    }

    //Returns a damage value between the minimum and maximum damages
    @Override
    public int getDamage() 
    {
        int difference = maximum - minimum;
        int effect = (int) (Math.random() * (difference + 1) + minimum);
        int damage = effect;
        return damage;
    }

    //Retrieve random defence of Slime based on the initialized minimum and maximum values
    @Override
    public int getDefence() 
    {
        int minimum = 0;
        int maximum = 2;
        int difference = maximum - minimum;
        int damage = (int) (Math.random() * (difference + 1) + minimum);
        return damage;
    }

    //Retrieve the gold to be awarded to a player after they defeat Slime
    @Override
    public int goldAward() 
    {
        return 10;
    }
    
    ////Retrieves special abilities to be added to the goblin based on a 20% probability
    @Override
    public int getSpecialAbilities() 
    {
        int damage = getDamage();
        double probability = Math.random();
        if (probability < 0.2)
        {
            damage = 0;
        }
        return damage;
    }
}