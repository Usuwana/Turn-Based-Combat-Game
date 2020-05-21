import java.util.*;

public interface GameCharacter
{
    public void setName(String name);
    public void getName();
    public void addWeapon(String name);
    public void addArmour(String name);
    public void addPotion(String name);
    public void setWeapon(String name);
    public void setArmour(String name);
    public void setPotion(String name);
    public int getMaxHealth();
    public int getCurrHealth();
    public String getWeapon(String name);
    public String getArmour(String name);
    public String getPotion(String name);
    public void getCurrentWeapons();
    public void getCurrentArmoury();
    public void getCurrentPotions();
    public int getGold();

}