import java.util.*;

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