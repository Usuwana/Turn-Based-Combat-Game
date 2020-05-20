import java.util.*;
import java.io.*;

public class Weapons extends Inventory 
{
    private String name;
    private int minDamage;
    private int maxDamage;
    private int cost;
    private String damageType;
    private String weaponType;

    @Override
    public void setItem(String name) 
    {
        if ((name.equals("Short Sword"))) 
        {
            this.name = name;
            minDamage = 5;
            maxDamage = 9;
            cost = 10;
            damageType = "Slashing";
            weaponType = "Sword";

        }
        else if ((name.equals("Great Axe")))
        {
            this.name = name;
            minDamage = 8;
            maxDamage = 15;
            cost = 15;
            damageType = "Slashing";
            weaponType = "Axe";
        }
        else if ((name.equals("Magic Staff")))
        {
            this.name = name;
            minDamage = 1;
            maxDamage = 40;
            cost = 20;
            damageType = "Bludgeoning";
            weaponType = "Staff";
        }
        else
        {
            throw new IllegalArgumentException("Invalid weapon name. Weapon not available in game");
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
        return minDamage;
    }

    @Override
    public int getMaxEffect() 
    {
        return maxDamage;
    }

    
}