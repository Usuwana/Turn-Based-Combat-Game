/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Used to modify characteristics of a weapon item
* Project: Turn Based Combat Game
* Date Last Modified: 26/05/2020
*
********************************************************************************************************************************************************/
package Model;
//Inherits from super class Weapons
public abstract class AddEnchantments extends Weapons
{
    //Used to update contents of Weapons object at runtime
    protected Weapons next;

    // Initialises the weapon object to be modified
    public AddEnchantments(Weapons newWeapon)
    {
        next = newWeapon;
    }

    //Definition of methods to be used by sub classes
    public abstract String getEnchantment();
    public abstract int enchantmentCost();

    // Overrides the method definition in the super class to set it's own implementation. Sets the updated item/weapon name
    @Override
    public void setItem(String name) 
    {
       next.setItem(name);
    }

    //Retrieves the updated symbol of a weapon
    @Override
    public char getSymbol() 
    {
        return next.getSymbol();
    }
    
    //Retrieves the updated name of  weapon
    @Override
    public String getName()
    {
        return next.getName();
    }

    //Retrieves the updated cost of a weapon
    @Override
    public int getCost() 
    {
        return next.getCost();
    }

    //Retrieves the updated minimum effect of a weapon
    @Override
    public int getMinEffect() 
    {
        return next.getMinEffect();
    }

    //Retrieves the updated maximum effect of a weapon
    @Override
    public int getMaxEffect() 
    {
        return next.getMaxEffect();
    }

    //Retrieves the updated overall effect of a weapon
    @Override
    public int getOverallEffect()
    {
        return next.getOverallEffect();
    }
    
}