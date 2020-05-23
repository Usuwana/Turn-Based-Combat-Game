import java.util.*;

public interface Enemies 
{
    public String getName();
    public void setHealth(int health);
    public int getMaxHealth();
    public int getCurrHealth();
    public int getMinDamage();
    public int getMaxDamage();
    public int getDamage();
    public int getDefence();
    public int goldAward();
    //public void getSpecialAbilities();    
}