import java.util.*;

public class PlayerCharacter implements GameCharacter
{
    String name;

    @Override
    public void setName(String name) 
    {
        this.name = name;

    }

    @Override
    public void getName() 
    {
        System.out.println(this.name +"\n");
    }

    @Override
    public void setWeapon() 
    {
        // TODO Auto-generated method stub

    }

    @Override
    public Object getWeapon() 
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
    public void setArmour() 
    {

    }

    @Override
    public Object getArmour() 
    {
        return null;
    }

    @Override
    public int getGold() 
    {
        return 100;
    }
    
}