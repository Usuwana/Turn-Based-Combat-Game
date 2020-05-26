/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Carries information about the Power-Up enchantment and what it adds to a weapon. Meant to multiply the damage of a weapon by 1.1
* Project: Turn Based Combat Game 
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/
package Model;
//Inherits from super class AddEnchantments
public class PowerUp extends AddEnchantments
{

    public PowerUp(Weapons newWeapon) 
    {
        super(newWeapon);
    }

    //Retrieve name of Power-Up enchantment
    @Override
    public String getEnchantment()
    {
        return "Power-Up";
    }

    //Retrieve cost of Power-Up enchantment
    @Override
    public int enchantmentCost()
    {
        return 10;
    }

    //Retrieve updated cost of weapon after adding Power-Up enchantment
    @Override
    public int getCost() 
    {
        return next.getCost() + enchantmentCost();
    }

    //Retrieve updated effect of weapon after adding Power-Up enchantment
    @Override
    public  int getOverallEffect()
    {
        return (int)(next.getOverallEffect()*1.1);
    }
    
}