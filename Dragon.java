import java.util.*;

public class Dragon implements Enemies 
{

    @Override
    public String getName() 
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getMaxHealth() 
    {
        return 100;
    }

    @Override
    public int getCurrHealth() 
    {
        return 100;
    }

    @Override
    public int getMinAttDamage() 
    {
        return 15;
    }

    @Override
    public int getMaxAttDamage() 
    {
        return 30;
    }

    @Override
    public int getMinDefDamage() 
    {
        return 15;
    }

    @Override
    public int getMaxDefDamage() 
    {
        return 20;
    }

    @Override
    public void getSpecialAbilities() 
    {
        // TODO Auto-generated method stub

    }

    @Override
    public int goldAward() 
    {
        return 100;
    }
    
}