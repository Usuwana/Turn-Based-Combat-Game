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
    public void setGold(int gold);
    public int getMaxHealth();
    public int getCurrHealth();
    public String getWeapon(String name);
    public String getArmour(String name);
    public String getPotion(String name);
    public String getcurWeapon();
    public String getcurArmour();
    public String getcurPotion();
    public void getCurrentWeapons();
    public void getCurrentArmoury();
    public void getCurrentPotions();
    public int getGold();
    public void removeWeapon(String name);
    public void removeArmour(String name);
    public void removePotions(String name);

}