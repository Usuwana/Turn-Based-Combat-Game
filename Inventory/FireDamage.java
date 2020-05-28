/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Carries information about the fire damage enchantment and what it adds to a weapon
* Project: Turn Based Combat Game
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/
package Inventory;
//Inherits from super class AddEnchantments
public class FireDamage extends AddEnchantments
{

    public FireDamage(Weapons newWeapon) 
    {
        super(newWeapon);

    }

    //Retrieve name of enchantment Fire Damage
    @Override
    public String getEnchantment()
    {
        return "Fire Damage";
    }

    //Retrieve cost of Fire Damage
    @Override
    public int enchantmentCost()
    {
        return 20;
    }

    //Retrieve updated cost of weapon when fire damage is added to it
    @Override
    public int getCost() 
    {
        return next.getCost() + enchantmentCost();
    }

    //Retrieve updated effect of weapon when fire damage is added to it
    @Override
    public  int getOverallEffect()
    {
        int addition =(int) ((Math.random() *(10-5)) + 5);
        return next.getOverallEffect()+ addition;
    }
    
}