import java.util.*;
import java.math.*;

public class FireDamage extends AddEnchantments
{

    public FireDamage(Weapons newWeapon) 
    {
        super(newWeapon);

    }

    @Override
    public String getEnchantment()
    {
        return "Fire Damage";
    }

    @Override
    public int enchantmentCost()
    {
        return 20;
    }

    @Override
    public int getCost() 
    {
        return next.getCost() + enchantmentCost();
    }

    @Override
    public  int getOverallEffect()
    {
        int addition =(int) ((Math.random() *(10-5)) + 5);
        return next.getOverallEffect()+ addition;
    }
    
}