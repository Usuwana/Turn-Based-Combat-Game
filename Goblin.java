import java.util.*;

public class Goblin implements Enemies 
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
        return 30;
    }

    @Override
    public int getCurrHealth() 
    {
        return 30;
    }

    @Override
    public int getMinAttDamage() 
    {
        return 3;
    }

    @Override
    public int getMaxAttDamage() 
    {
        return 8;
    }

    @Override
    public int getMinDefDamage() 
    {
        return 4;
    }

    @Override
    public int getMaxDefDamage() 
    {
        return 8;
    }

    @Override
    public void getSpecialAbilities() 
    {
        // TODO Auto-generated method stub

    }

    @Override
    public int goldAward() 
    {
        return 20;
    }
    
}