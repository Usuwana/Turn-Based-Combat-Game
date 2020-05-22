import java.util.*;

public class Potions extends Inventory 
{
    private final char symbol = 'P';
    private String name;
    private int minEffect;
    private int maxEffect;
    private int cost;
    private boolean healing;

    @Override
    public void setItem(String name) 
    {
        try
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
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid Potion name. Potion not available in game");
        }
    }

    @Override
    public char getSymbol() 
    {
        return symbol;
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

    public boolean getHealing() 
    {
        return healing;
    }
    
}