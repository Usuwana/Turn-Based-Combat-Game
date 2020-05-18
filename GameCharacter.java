import java.util.*;

public interface GameCharacter
{
    public void setName(String name);
    public void getName();
    public void setWeapon();
    public Object getWeapon();
    public int getMaxHealth();
    public int getCurrHealth();
    public void setArmour();
    public Object getArmour();
    public int getGold();

}