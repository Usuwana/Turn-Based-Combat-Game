import java.util.*;

public class Goblin implements Enemies 
{
    private String name = "Goblin";
    private int health = 30;
    private int minimum = 3;
    private int maximum = 8;

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
        return 30;
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
        if (probability < 0.5)
        {
            damage = effect*3;
        }*/
        return damage;
    }

    @Override
    public int getDefence() 
    {
        int minimum = 4;
        int maximum = 8;
        int difference = maximum - minimum;
        int damage = (int) (Math.random() * (difference + 1) + minimum);
        return damage;
    }

    @Override
    public int goldAward() 
    {
        return 20;
    }

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