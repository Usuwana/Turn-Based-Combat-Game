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