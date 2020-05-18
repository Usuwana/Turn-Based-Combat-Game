import java.util.*;

public class Ogre implements Enemies 
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
        return 40;
    }

    @Override
    public int getCurrHealth() 
    {
        return 40;
    }

    @Override
    public int getMinAttDamage() 
    {
        return 5;
    }

    @Override
    public int getMaxAttDamage() 
    {
        return 10;
    }

    @Override
    public int getMinDefDamage() 
    {
        return 6;
    }

    @Override
    public int getMaxDefDamage() 
    {
        return 12;
    }

    @Override
    public void getSpecialAbilities() 
    {
        // TODO Auto-generated method stub

    }

    @Override
    public int goldAward() 
    {
        return 40;
    }
    
}