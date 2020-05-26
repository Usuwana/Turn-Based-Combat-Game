/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Date Last Modified: 26/05/2020
* Responsibility: Carries information about the Power-Up enchantment and what it adds to a weapon. Meant to multiply the damage of a weapon by 1.1
*
********************************************************************************************************************************************************/


//import java.util.*;

public class PowerUp extends AddEnchantments
{

    public PowerUp(Weapons newWeapon) 
    {
        super(newWeapon);
    }

    @Override
    public String getEnchantment()
    {
        return "Power-Up";
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
        return (int)(next.getOverallEffect()*1.1);
    }
    
}