import java.util.*;

public class Slime implements Enemies 
{
    private String name = "Slime";

    @Override
    public String getName() 
    {
        return name;
    }

    @Override
    public int getMaxHealth() 
    {
        return 10;
    }

    @Override
    public int getCurrHealth() 
    {
        return 10;
    }

    @Override
    public int getDamage() 
    {
        int minimum = 3;
        int maximum = 5;
        int difference = maximum - minimum;
        int effect = (int) (Math.random() * (difference + 1) + minimum);
        int damage = effect;
        double probability = Math.random();
        if (probability < 0.2)
        {
            damage = 0;
        }
        return damage;
    }

    @Override
    public int getDefence() 
    {
        int minimum = 0;
        int maximum = 2;
        int difference = maximum - minimum;
        int damage = (int) (Math.random() * (difference + 1) + minimum);
        return damage;
    }

    @Override
    public int goldAward() 
    {
        return 10;
    }
    
}