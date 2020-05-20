import java.util.*;

public abstract class CharacterModify implements GameCharacter 
{
    protected GameCharacter next;

    public CharacterModify(GameCharacter next)
    {
        this.next = next;
    }

    @Override
    public void getName() 
    {
        next.getName();
    }


    @Override
    public String getWeapon(String name) 
    {
        return next.getWeapon(name);
    }

    @Override
    public int getMaxHealth() 
    {
        return next.getMaxHealth();
    }

    @Override
    public int getCurrHealth() 
    {
        return next.getCurrHealth();
    }

    @Override
    public String getArmour(String name) 
    {
        return next.getArmour(name);
    }

    @Override
    public int getGold() 
    {
        return next.getGold();
    }

}