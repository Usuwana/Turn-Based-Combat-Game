import java.util.*;

public class Armour extends Inventory 
{

    private String name;
    private int minDefence;
    private int maxDefence;
    private int cost;
    private String material;

    @Override
    public void setItem(String name) 
    {
        if ((name.equals("Leather Armour")))
        {
            this.name = name;
            minDefence = 5;
            maxDefence = 15;
            cost = 10;
            material = "Leather";
        }
        else if ((name.equals("Chain Mail")))
        {
            this.name = name;
            minDefence = 10;
            maxDefence = 18;
            cost = 50;
            material = "Chain";
        }
        else if ((name.equals("Dragon Skin")))
        {
            this.name = name;
            minDefence = 20;
            maxDefence = 30;
            cost = 80;
            material = "Dragon Scale";
        }
        else
        {
            throw new IllegalArgumentException("Invalid Armour name. Armour not available in game");
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
        return minDefence;
    }

    @Override
    public int getMaxEffect() 
    {           
        return maxDefence;
    }


}