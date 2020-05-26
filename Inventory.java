/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Abstract class acting as a super class for all the items to be owned by the character. Defines methods to be used by all the inventory types
* Project: Turn Based Combat Game 
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/


//import java.util.*;

public abstract class Inventory 
{
    public abstract void setItem(String name);
    public abstract char getSymbol();
    public abstract String getName();
    //public abstract void getItem();
    public abstract int getCost();
    public abstract int getMinEffect();
    public abstract int getMaxEffect();
    public abstract int getOverallEffect();

    
}