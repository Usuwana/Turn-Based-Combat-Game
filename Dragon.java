import java.util.*;

public class Dragon implements Enemies 
{
    private String name = "Dragon";
    private int health = 100;
    private int minimum = 15;
    private int maximum = 30;

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
        if (probability < 0.35)
        {
            if (probability < 0.25)
            {
                damage = effect*2;
            }
            else if(probability < 0.1)
            {
                health = getCurrHealth() + 10;
            }
        }*/
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

    @Override
    public int getSpecialAbilities()
    {
        int effect = 0;
        double probability = Math.random();
        if (probability < 0.35)
        {
            if (probability < 0.25)
            {
                //damage = getDamage()*2;
                effect = 1;
            }
            else if(probability < 0.1)
            {
                //health = getCurrHealth() + 10;
                effect = 2;
            }
        }
        return effect

    }
    
}