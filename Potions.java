/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Used to set, modify and carry characteristics of a potion item
* Project: Turn Based Combat Game
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/
//package Model;
//Inherits from super class Inventory
public class Potions extends Inventory 
{
    private char symbol;
    private String name;
    private int minEffect;
    private int maxEffect;
    private int cost;
    private boolean healing;

    //Set the values of a potion item's attributes based on it's name depending on whether the name is valid or not 
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
    }

    //Retrieves the symbol of a weapon object
    @Override
    public char getSymbol() 
    {
        return symbol;
    }

    //Retrieves the set name of a weapon object
    @Override
    public String getName() 
    {
        return name;
    }

    //Retrieve the set cost of a weapon object
    @Override
    public int getCost() 
    {
        return cost;
    }

    //Retrieves the set minium effect of a weapon object
    @Override
    public int getMinEffect() 
    {
        return minEffect;
    }

    //Retrieves the set maximum effect of a weapon object
    @Override
    public int getMaxEffect() 
    {
        return maxEffect;
    }

    //Retrieves the overall effect of a weapon object with a random number between the minimum and maximum effects
    @Override
    public  int getOverallEffect()
    {
        int effect = (int) (Math.random() * ((maxEffect - minEffect)+1) + minEffect);
        return effect;
    }
    
}