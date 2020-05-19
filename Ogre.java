import java.util.*;
import java.math.*;

public class Ogre implements Enemies 
{
    private String name = "Ogre";

    @Override
    public String getName() 
    {
        return name;
    }

    @Override
    public int getMaxHealth() 
    {
        return 40;
    }

    @Override
    public int getCurrHealth() 
    {
        return 40;
    }

    @Override
    public int getDamage() 
    {
        int minimum = 5;
        int maximum = 10;
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