/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Carries information about the damage + 2 enchantment and what it adds to a weapon. Meant to add 2 to the damage of a weapon
* Project: Turn Based Combat Game
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/
package Model;
//Inherits from super class AddEnchantments
public class TwoDamage extends AddEnchantments
{

    public TwoDamage(Weapons newWeapon) 
    {
        super(newWeapon);
        
    }

    //Retrieve name of enchantment
    @Override
    public String getEnchantment()
    {
        return "Damage+2";
    }

    //Retrieve cost of enchantment
    @Override
    public int enchantmentCost()
    {
        return 5;
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
        return next.getOverallEffect()+2;
    }
    
}