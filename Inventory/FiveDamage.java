/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Carries information about the damage + 5 enchantment and what it adds to a weapon. Meant to add 5 to the damage of a weapon
* Project: Turn Based Combat Game
* Date Last Modified: 28/05/2020
********************************************************************************************************************************************************/
package Inventory;

//Inherits from super class AddEnchantments
public class FiveDamage extends AddEnchantments
{

    public FiveDamage(Weapons newWeapon) 
    {
        super(newWeapon);
    }

    //Retrieve name of enchantment
    @Override
    public String getEnchantment()
    {
        return "Damage+5";
    }

    //Retrieve cost of enchantment
    @Override
    public int enchantmentCost()
    {
        return 10;
    }

    //Retrieve updated cost of weapon when enchantment is added
    @Override
    public int getCost() 
    {
        return next.getCost() + enchantmentCost();
    }

    //Retrieve updated effect of weapon when enchantment is added
    @Override
    public  int getOverallEffect()
    {
        return next.getOverallEffect() + 5;
    }
    
}