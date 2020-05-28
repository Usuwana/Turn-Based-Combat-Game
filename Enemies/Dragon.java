/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Used to set, modify and carry the characteristics of a dragon enemy
* Project: Turn Based Combat Game
* Date Last Modified: 28/05/2020
********************************************************************************************************************************************************/

package Enemies;
//Implements Enemies interface
public class Dragon implements Enemies 
{
    private final String name = "Dragon";
    private int health = 100;
    private int minimum = 15;
    private int maximum = 30;

    //Retrieves the name of the Dragon
    @Override
    public String getName() 
    {
        return name;
    }

    //Sets the health of the dragon to any value not surpassing the maximum health
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

    //Retrieves the maximum health of the dragon
    @Override
    public int getMaxHealth() 
    {
        return 100;
    }

    //Retrieves the current health of the dragon
    @Override
    public int getCurrHealth() 
    {
        return health;
    }

    //Retrieves the minimum damage the dragon can cause
    @Override
    public int getMinDamage()
    {
        return minimum;
    }

    //Retrieves the maximum damage the dragon can cause
    @Override
    public int getMaxDamage()
    {
        return maximum;
    }

    //Retrieves random number between minimum and maximum damage 
    @Override
    public int getDamage() 
    {
        int difference = maximum - minimum;
        int effect = (int) (Math.random() * (difference + 1) + minimum);
        int damage = effect;
        return damage;
    }

    //Retrieves a random number between the minimum and maximum initialized numbers to use as defence
    @Override
    public int getDefence() 
    {
        int minimum = 15;
        int maximum = 20;
        int difference = maximum - minimum;
        int damage = (int) (Math.random() * (difference + 1) + minimum);
        return damage;
    }

    //Retrieve gold to be awarded to player if they defeat the dragon
    @Override
    public int goldAward() 
    {
        return 100;
    }

    //Return type of invoked special abilities of dragon based on a generated random number
    @Override
    public int getSpecialAbilities()
    {
        int effect = 0;
        double probability = Math.random();
        if (probability < 0.35)
        {
            if (probability < 0.25)
            {
                effect = 1; //multiply damage by 2
            }
            else if(probability < 0.1)
            {
                effect = 2; //heal dragon by 10
            }
        }
        return effect;

    }
    
}