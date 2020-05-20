import java.util.*;

public interface GameCharacter
{
    public void setName(String name);
    public void getName();
    public void setWeapon();
    public void setArmour();
    public void setInventory();
    public int getMaxHealth();
    public int getCurrHealth();
    public List<Inventory> getInventory();
    public Inventory getWeapon();
    public Inventory getArmour();
    public int getGold();

}