import java.util.*;

public interface Enemies 
{
    public String getName();
    public int getMaxHealth();
    public int getCurrHealth();
    public int getMinAttDamage();
    public int getMaxAttDamage();
    public int getMinDefDamage();
    public int getMaxDefDamage();
    public int goldAward();
    public void getSpecialAbilities();    
}