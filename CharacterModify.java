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
    public Object getWeapon() 
    {
        return next.getWeapon();
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
    public Object getArmour() 
    {
        return next.getArmour();
    }

    @Override
    public int getGold() 
    {
        return next.getGold();
    }

}