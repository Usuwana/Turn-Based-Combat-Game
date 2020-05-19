import java.util.*;

public interface GameCharacter
{
    public void setName(String name);
    public void getName();
    public void setWeapon();
    public int getMaxHealth();
    public int getCurrHealth();
    public Weapons getWeapon();
    public Armour getArmour();
    public int getGold();

}