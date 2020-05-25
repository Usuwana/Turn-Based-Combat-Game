/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Date Last Modified: 26/05/2020
* Responsibility: Carries information about the five damage enchantment and what it adds to a weapon. Meant to add 5 to the damage of a weapon
*
********************************************************************************************************************************************************/


import java.util.*;

public class FiveDamage extends AddEnchantments
{

    public FiveDamage(Weapons newWeapon) 
    {
        super(newWeapon);
    }

    @Override
    public String getEnchantment()
    {
        return "Damage+5";
    }

    @Override
    public int enchantmentCost()
    {
        return 10;
    }

    @Override
    public int getCost() 
    {
        return next.getCost() + enchantmentCost();
    }

    @Override
    public  int getOverallEffect()
    {
        return next.getOverallEffect() + 5;
    }
    
}