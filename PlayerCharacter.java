import java.util.*;

public class PlayerCharacter implements GameCharacter
{
    private String name;
    private List<Inventory> items;

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
        
    }

    @Override
    public void setArmour() 
    {
        
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
    public Inventory getArmour() 
    {
        return null;
    }

    @Override
    public Inventory getWeapon() 
    {
        Inventory weapon = new Weapons();
        //weapon.setItem
        return null;
    }


    @Override
    public int getGold() 
    {
        return 100;
    }

    @Override
    public void setInventory() 
    {
    
    }

    @Override
    public List<Inventory> getInventory() 
    {
        return null;
    }
    
}