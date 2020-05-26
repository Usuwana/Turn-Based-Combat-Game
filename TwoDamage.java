/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Carries information about the damage + 2 enchantment and what it adds to a weapon. Meant to add 2 to the damage of a weapon
* Project: Turn Based Combat Game
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/


//import java.util.*;

public class TwoDamage extends AddEnchantments
{

    public TwoDamage(Weapons newWeapon) 
    {
        super(newWeapon);
        
    }

    @Override
    public String getEnchantment()
    {
        return "Damage+2";
    }

    @Override
    public int enchantmentCost()
    {
        return 5;
    }

    @Override
    public int getCost() 
    {
        return next.getCost() + enchantmentCost();
    }

    @Override
    public  int getOverallEffect()
    {
        return next.getOverallEffect()+2;
    }
    
}