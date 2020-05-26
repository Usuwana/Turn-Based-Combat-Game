/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Used to set, modify and carry characteristics of an armour item
* Project: Turn Based Combat Game
* Date Last Modified: 26/05/2020
* 
********************************************************************************************************************************************************/
package Model;

//Inherits from super class Inventory
public class Armour extends Inventory 
{
    private final char symbol = 'A';
    private String name;
    private int minDefence;
    private int maxDefence;
    private int cost;
    private String material;

    //Set the values of an armour item's attributes based on it's name depending on whether the name is valid or not 
    @Override
    public void setItem(String name) 
    {
        try
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
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid Armour name. Armour not available in game");
        }
    }

    //Retrieves the symbol of an armour item
    @Override
    public char getSymbol() 
    {
        return symbol;
    }

    // Retrives the set name of an armour object
    @Override
    public String getName() 
    {
        return name;
    }

    //Retrieve the set cost of an armour object
    @Override
    public int getCost() 
    {
        return cost;
    }

    //Retrieves the set minimum effect of an armour object
    @Override
    public int getMinEffect() 
    {
        return minDefence;
    }

    //Retrieves the set maximum effect of an armour object
    @Override
    public int getMaxEffect() 
    {           
        return maxDefence;
    }

    //Retrieves the overall effect of an armour object with a random number between the minimum and maximum effects
    @Override
    public  int getOverallEffect()
    {
        int effect = (int) (Math.random() * ((maxDefence - minDefence)+1) + minDefence);
        return effect;
    }

}