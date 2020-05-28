/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Abstract class acting as a super class for all the items to be owned by the character. Defines methods to be used by all the inventory types
* Project: Turn Based Combat Game 
* Date Last Modified: 28/05/2020
********************************************************************************************************************************************************/
package Inventory;

public abstract class Inventory 
{
    public abstract void setItem(String name); //Set the name and attributes of a particular type of inventory
    public abstract char getSymbol(); //Retrieve symbol of a particular type of inventory
    public abstract String getName(); //Retrieve the name of a particular type of inventory
    public abstract int getCost(); //Retrieve the cost of a particular type of inventory
    public abstract int getMinEffect(); //Retireve the minimum possible effect of an item
    public abstract int getMaxEffect(); //Retrieve the maximum possible effect of an item
    public abstract int getOverallEffect(); //Retrieve the effect caused each time an item is used
}