import java.util.*;

public class Potions extends Inventory 
{
    private String name;
    private int minEffect;
    private int maxEffect;
    private int cost;
    private boolean healing;

    @Override
    public void setItem(String name) 
    {
        if ((name.equals("Potion of Healing")))
        {
            this.name = name;
            minEffect = 5;
            maxEffect = 10;
            cost = 12;
            healing = true;
        }
        else if ((name.equals("Potion of Greater Healing")))
        {
            this.name = name;
            minEffect = 15;
            maxEffect = 20;
            cost = 20;
            healing = true;

        }
        else if ((name.equals("Explosive Potion")))
        {
            this.name = name;
            minEffect = 20;
            maxEffect = 20;
            cost = 20;
            healing = false;
        }
        else
        {
            throw new IllegalArgumentException("Invalid Potion name. Potion not available in game");
        }
    }

    @Override
    public String getName() 
    {
        return name;
    }

    @Override
    public int getCost() 
    {
        return cost;
    }

    @Override
    public int getMinEffect() 
    {
        return minEffect;
    }

    @Override
    public int getMaxEffect() 
    {
        return maxEffect;
    }
    
}