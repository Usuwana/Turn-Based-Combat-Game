/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Meant to set, modify and contain information about the enemy Goblin
* Project: Turn Based Combat Game 
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/
package Model;
//Implements Enemies interface
public class Goblin implements Enemies 
{
    private final String name = "Goblin";
    private int health = 30;
    private int minimum = 3;
    private int maximum = 8;

    //Retrieve name of Gobln
    @Override
    public String getName() 
    {
        return name;
    }

    //Set the health of Goblin to any number that does not surpass the maximum allowed
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
        return 30;
    }

    //Retrieves the current health of the goblin
    @Override
    public int getCurrHealth() 
    {
        return health;
    }

    //Retrieves the minimum damage the goblin can cause
    @Override
    public int getMinDamage()
    {
        return minimum;
    }

    //Retrieves the maximum damage the goblin can cause
    @Override
    public int getMaxDamage()
    {
        return maximum;
    }

    //Retrieves the overall damage the goblin can cause. The value is a number between the minimum and maximum damages
    @Override
    public int getDamage() 
    {
        
        int difference = maximum - minimum;
        int effect = (int) (Math.random() * (difference + 1) + minimum);
        int damage = effect;
        return damage;
    }

    //Retrieves the defence the goblin can give. The value is a number between the initialized minimum and maximum values
    @Override
    public int getDefence() 
    {
        int minimum = 4;
        int maximum = 8;
        int difference = maximum - minimum;
        int damage = (int) (Math.random() * (difference + 1) + minimum);
        return damage;
    }

    //Retrieves gold to be given to player after defeating goblin
    @Override
    public int goldAward() 
    {
        return 20;
    }

    //Retrieves special abilities to be added to the goblin based on a 50% probability
    @Override
    public int getSpecialAbilities()
    {
        int damage = 0;
        double probability = Math.random();
        if (probability < 0.5)
        {
            damage = getDamage()+3;
        }

        return damage;
    }
    
}