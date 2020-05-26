/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Used to set, modify and carry characteristics of a potion item
* Project: Turn Based Combat Game
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/


//import java.util.*;

public class Potions extends Inventory 
{
    private char symbol;
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
                symbol = 'H';
                minEffect = 5;
                maxEffect = 10;
                cost = 12;
                healing = true;
            }
            else if ((name.equals("Potion of Greater Healing")))
            {
                this.name = name;
                symbol = 'H';
                minEffect = 15;
                maxEffect = 20;
                cost = 20;
                healing = true;

            }
            else if ((name.equals("Explosive Potion")))
            {
                this.name = name;
                symbol = 'D';
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
        return minEffect;
    }

    @Override
    public int getMaxEffect() 
    {
        return maxEffect;
    }

    /*public boolean getHealing() 
    {
        return healing;
    }*/

    @Override
    public  int getOverallEffect()
    {
        int effect = (int) (Math.random() * ((maxEffect - minEffect)+1) + minEffect);
        return effect;
    }
    
}