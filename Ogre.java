import java.util.*;
import java.math.*;

public class Ogre implements Enemies 
{
    private String name = "Ogre";
    private int health = 40;
    private int minimum = 5;
    private int maximum = 10;

    @Override
    public String getName() 
    {
        return name;
    }

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

    @Override
    public int getMaxHealth() 
    {
        return 40;
    }

    @Override
    public int getCurrHealth() 
    {
        return health;
    }

    @Override
    public int getMinDamage()
    {
        return minimum;
    }

    @Override
    public int getMaxDamage()
    {
        return maximum;
    }

    @Override
    public int getDamage() 
    {
        int difference = maximum - minimum;
        int effect = (int) (Math.random() * (difference + 1) + minimum);
        int damage = effect;
        double probability = Math.random();
        if (probability < 0.2)
        {
            damage = effect + effect;
        }
        return damage;
    }

    @Override
    public int getDefence() 
    {
        int minimum = 6;
        int maximum = 12;
        int difference = maximum - minimum;
        int damage = (int) (Math.random() * (difference + 1) + minimum);
        return damage;
    }

    @Override
    public int goldAward() 
    {
        return 40;
    }
    
}