/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Used to set, modify and carry characteristics of a weapon item without enchantment modifications
* Project: Turn Based Combat Game
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/


//import java.util.*;

public class CurrentWeapon extends Weapons
{
    private final char symbol = 'W';
    private String name;
    private int minDamage;
    private int maxDamage;
    private int cost;
    private String damageType;
    private String weaponType;

    @Override
    public void setItem(String name) 
    {
        try
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
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid weapon name. Weapon not available in game");
        }
        //return name;
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
        return minDamage;
    }

    @Override
    public int getMaxEffect() 
    {
        return maxDamage;
    }

    @Override
    public  int getOverallEffect()
    {
        int effect = (int) (Math.random() * ((maxDamage - minDamage)+1) + minDamage);
        return effect;
    }
    
}