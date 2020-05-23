import java.util.*;

public class Dragon implements Enemies 
{
    private String name = "Dragon";
    private int health = 100;

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
        return 100;
    }

    @Override
    public int getCurrHealth() 
    {
        return health;
    }

    @Override
    public int getDamage() 
    {
        int minimum = 15;
        int maximum = 30;
        int difference = maximum - minimum;
        int effect = (int) (Math.random() * (difference + 1) + minimum);
        int damage = effect;
        double probability = Math.random();
        if (probability < 0.35)
        {
            if (probability < 0.25)
            {
                damage = effect*2;
            }
            else if(probability < 0.1)
            {
                int health = getCurrHealth() + 10;
            }
        }
        return damage;
    }

    @Override
    public int getDefence() 
    {
        int minimum = 15;
        int maximum = 20;
        int difference = maximum - minimum;
        int damage = (int) (Math.random() * (difference + 1) + minimum);
        return damage;
    }

    @Override
    public int goldAward() 
    {
        return 100;
    }
    
}