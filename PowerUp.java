import java.util.*;

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