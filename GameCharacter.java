import java.util.*;

public interface GameCharacter
{
    public void setName(String name);
    public void getName();
    public void setWeapon(String name);
    public void setArmour(String name);
    public void setPotion(String name);
    //public void setInventory(Inventory item);
    public int getMaxHealth();
    public int getCurrHealth();
    //public List<Inventory> getInventory();
    public Inventory getWeapon(String name);
    public Inventory getArmour(String name);
    public Inventory getPotion(String name);
    public int getGold();

}