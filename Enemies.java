/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Date Last Modified: 26/05/2020
* Responsibility: Common interface used to define methods to be used by all enemies faced by the character
*
********************************************************************************************************************************************************/


//import java.util.*;

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
    public int getSpecialAbilities();    
}