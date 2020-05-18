import java.util.*;

public class Slime implements Enemies 
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
        return 10;
    }

    @Override
    public int getCurrHealth() 
    {
        return 10;
    }

    @Override
    public int getMinAttDamage() 
    {
        return 3;
    }

    @Override
    public int getMaxAttDamage() 
    {
        return 5;
    }

    @Override
    public int getMinDefDamage() 
    {
        return 0;
    }

    @Override
    public int getMaxDefDamage() 
    {
        return 2;
    }

    @Override
    public void getSpecialAbilities() 
    {
        // TODO Auto-generated method stub

    }

    @Override
    public int goldAward() 
    {
        return 10;
    }
    
}