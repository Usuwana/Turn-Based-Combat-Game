import java.util.*;

public class Slime implements Enemies 
{
    private String name = "Slime";
    private int health = 10;
    private int minimum = 3;
    private int maximum = 5;

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
        return 10;
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
        /*double probability = Math.random();
        if (probability < 0.2)
        {
            damage = 0;
        }*/
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